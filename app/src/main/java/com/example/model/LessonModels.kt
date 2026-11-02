package com.example.model

data class Vocabulary(
    val id: String,
    val korean: String,
    val sinhalaMeaning: String,
    val sinhalaPronunciation: String,
    val englishMeaning: String,
    val category: String,
    val lessonId: Int,
    val bookId: Int,
    val isImportantForExam: Boolean = true
)

data class GrammarExample(
    val korean: String,
    val sinhala: String,
    val english: String = ""
)

data class GrammarPoint(
    val id: String,
    val patternKorean: String,
    val titleSinhala: String,
    val ruleExplanationSinhala: String,
    val usageCondition: String,
    val examples: List<GrammarExample>
)

data class DialogueLine(
    val id: Int,
    val speaker: String,
    val koreanText: String,
    val sinhalaText: String,
    val pronunciationSinhala: String
)

data class Dialogue(
    val id: String,
    val titleKorean: String,
    val titleSinhala: String,
    val lines: List<DialogueLine>,
    val contextNoteSinhala: String = ""
)

data class Lesson(
    val id: Int,
    val bookId: Int, // 1 or 2
    val koreanTitle: String,
    val sinhalaTitle: String,
    val englishTitle: String,
    val topicSinhala: String,
    val dialogues: List<Dialogue>,
    val vocabularies: List<Vocabulary>,
    val grammars: List<GrammarPoint>,
    val culturalNoteSinhala: String,
    val cultureTitleKorean: String = "문화 / 정보",
    val cultureTitleSinhala: String = "කොරියානු සංස්කෘතිය සහ තොරතුරු"
)
