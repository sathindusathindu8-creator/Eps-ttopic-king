package com.example.model

enum class QuestionType {
    READING,   // 읽기 (කියවීම)
    LISTENING  // 듣기 (සවන්දීම)
}

data class ExamQuestion(
    val id: Int,
    val type: QuestionType,
    val questionNumber: Int,
    val instructionKorean: String,
    val instructionSinhala: String,
    val audioScriptKorean: String? = null, // The script read by TTS for Listening questions
    val passageKorean: String? = null,     // Reading passage, signboard text, or notice
    val graphicSymbolEmoji: String? = null, // Graphic cue like 🚸 🚭 👷 🚗 🏢 ⏰
    val options: List<String>,              // 4 choices (Korean + Sinhala)
    val correctOptionIndex: Int,            // 0..3
    val explanationSinhala: String,         // Sinhala explanation of why this answer is correct
    val points: Int = 5                     // 40 questions x 5 = 200 marks (Official EPS-TOPIK standard)
)

data class MockExam(
    val id: String,
    val paperNumber: Int,
    val titleKorean: String,
    val titleSinhala: String,
    val descriptionSinhala: String,
    val totalTimeMinutes: Int = 50,
    val passMarks: Int = 110, // EPS-TOPIK typical pass range 100-110+ out of 200
    val totalMarks: Int = 200,
    val questions: List<ExamQuestion>
)

data class ExamResult(
    val examId: String,
    val paperTitleSinhala: String,
    val score: Int,
    val maxScore: Int = 200,
    val readingScore: Int,
    val listeningScore: Int,
    val correctAnswersCount: Int,
    val totalQuestionsCount: Int,
    val passed: Boolean,
    val completedAt: Long = System.currentTimeMillis(),
    val userAnswers: Map<Int, Int> // questionId -> selectedOptionIndex
)
