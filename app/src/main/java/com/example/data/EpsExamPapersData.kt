package com.example.data

import com.example.model.ExamQuestion
import com.example.model.MockExam
import com.example.model.QuestionType

object EpsExamPapersData {
    val modelPapers: List<MockExam> = listOf(
        MockExam(
            id = "mock_paper_01",
            paperNumber = 1,
            titleKorean = "제1회 EPS-TOPIK 실전 모의고사 (කට්ටලය 01)",
            titleSinhala = "EPS-TOPIK අනුමාන ප්‍රශ්න පත්‍රය 01 (CBT Simulator)",
            descriptionSinhala = "නිල විභාග රටාවට අනුව කියවීම (읽기) සහ සවන්දීම (듣기) ප්‍රශ්න, හඬ පට සහ සිංහල විවරණ සහිතයි.",
            totalTimeMinutes = 50,
            passMarks = 110,
            totalMarks = 200,
            questions = listOf(
                // ---- READING (읽기) ----
                ExamQuestion(
                    id = 101,
                    type = QuestionType.READING,
                    questionNumber = 1,
                    instructionKorean = "[1~2] 다음 그림을 보고 맞는 단어나 문장을 고르십시오.",
                    instructionSinhala = "පහත රූපය/සංකේතය බලා නිවැරදි වචනය තෝරන්න.",
                    passageKorean = "【 🔧 🗜️ 컷팅/철사 작업 】",
                    graphicSymbolEmoji = "🔧",
                    options = listOf(
                        "① 톱 (කියත)",
                        "② 펜치 (ප්ලයර් එක)",
                        "③ 망치 (මිටිය)",
                        "④ 줄자 (මිනුම් පටිය)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "නිවැරදි පිළිතුර ② 펜치 (ප්ලයර් එක) වේ. කම්බි කැපීමට සහ නැවීමට 펜치 භාවිතා වේ. 톱 යනු කියතයි, 망치 යනු මිටියයි, 줄자 යනු මිනුම් පටියයි."
                ),
                ExamQuestion(
                    id = 102,
                    type = QuestionType.READING,
                    questionNumber = 2,
                    instructionKorean = "다음 표지판이 의미하는 것은 무엇입니까?",
                    instructionSinhala = "පහත අනතුරු ඇඟවීමේ පුවරුවෙන් අදහස් වන්නේ කුමක්ද?",
                    passageKorean = "【 관계자 외 출입금지 】\n(Unauthorized Personnel Do Not Enter)",
                    graphicSymbolEmoji = "🚫",
                    options = listOf(
                        "① 이곳에 주차할 수 없습니다. (වාහන නැවැත්විය නොහැක)",
                        "② 이곳에서 담배를 피울 수 없습니다. (දුම්බීම තහනම්)",
                        "③ 관계자가 아니면 들어갈 수 없습니다. (අදාළ සේවකයින් හැර ඇතුළුවීම තහනම්)",
                        "④ 안전모를 쓰지 않으면 안 됩니다. (ආරක්ෂිත හිස්වැසුම් පැළඳිය යුතුයි)"
                    ),
                    correctOptionIndex = 2,
                    explanationSinhala = "'관계자 외 출입금지' යනු අදාළ බලයලත් නිලධාරීන් හැර අනෙකුත් පුද්ගලයින්ට ඇතුළුවීම තහනම් බවයි. එබැවින් නිවැරදි පිළිතුර ③ වේ."
                ),
                ExamQuestion(
                    id = 103,
                    type = QuestionType.READING,
                    questionNumber = 3,
                    instructionKorean = "[3~4] 빈칸에 들어갈 가장 알맞은 것을 고르십시오.",
                    instructionSinhala = "හිස්තැනට ගැළපෙන වඩාත්ම නිවැරදි වචනය තෝරන්න.",
                    passageKorean = "가: 머리가 너무 아프고 열이 나요.\n나: 그럼 병원 옆에 있는 (      )에 가서 약을 사 드세요.",
                    options = listOf(
                        "① 은행 (බැංකුව)",
                        "② 약국 (ෆාමසිය)",
                        "③ 우체국 (තැපැල් කන්තෝරුව)",
                        "④ 식당 (ආපනශාලාව)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "හිස කැක්කුම සහ උණ ඇති විට ඖෂධ (약) මිලදී ගැනීමට යා යුත්තේ ෆාමසියට (약국) ය. එබැවින් නිවැරදි පිළිතුර ② 약국 වේ."
                ),
                ExamQuestion(
                    id = 104,
                    type = QuestionType.READING,
                    questionNumber = 4,
                    instructionKorean = "빈칸에 들어갈 가장 알맞은 문법을 고르십시오.",
                    instructionSinhala = "හිස්තැනට ගැළපෙන නිවැරදි ව්‍යාකරණ රටාව තෝරන්න.",
                    passageKorean = "작업장에서 프레스 기계를 작동할 때 손을 (      ) 조심하세요.",
                    options = listOf(
                        "① 다치도록 (තුවාල වන ලෙස)",
                        "② 다치지 않도록 (තුවාල නොවීමට)",
                        "③ 다치면서 (තුවාල වෙමින්)",
                        "④ 다친 후에 (තුවාල වූ පසු)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "වැඩබිමේ යන්ත්‍ර ක්‍රියාත්මක කිරීමේදී අනතුරක් නොවීමට පරිස්සම් වන්න යන උපදෙස සඳහා '-지 않도록 조심하세요' ව්‍යාකරණය යෙදේ. එබැවින් නිවැරදි පිළිතුර ② 다치지 않도록 වේ."
                ),
                ExamQuestion(
                    id = 105,
                    type = QuestionType.READING,
                    questionNumber = 5,
                    instructionKorean = "다음 글을 읽고 맞지 않는 것을 고르십시오.",
                    instructionSinhala = "පහත ඡේදය කියවා වැරදි ප්‍රකාශය තෝරන්න.",
                    passageKorean = "한국의 근로기준법상 1일 법정 근로시간은 8시간, 1주 40시간입니다. 하루 8시간을 넘어서 일하는 것을 '연장근로'라고 하며, 연장근로를 할 때는 통상임금의 50% 이상을 가산하여 수당으로 지급해야 합니다.",
                    options = listOf(
                        "① 하루 법정 근로시간은 8시간입니다. (දිනකට පැය 8කි)",
                        "② 1주 기본 근로시간은 40시간입니다. (සතියකට පැය 40කි)",
                        "③ 연장근로를 해도 추가 수당이 없습니다. (OT සඳහා අමතර මුදලක් නොලැබේ)",
                        "④ 8시간을 초과하면 연장근로가 됩니다. (පැය 8 ඉක්මවූ විට එය අතිකාල වේ)"
                    ),
                    correctOptionIndex = 2,
                    explanationSinhala = "ඡේදයේ පැහැදිලිව සඳහන් වන්නේ අතිකාල වැඩ සඳහා 50% ක අමතර දීමනාවක් (수당) හිමිවන බවයි. එබැවින් වැරදි ප්‍රකාශය වන්නේ ③ 'අමතර දීමනාවක් නොලැබේ' යන්නයි."
                ),
                ExamQuestion(
                    id = 106,
                    type = QuestionType.READING,
                    questionNumber = 6,
                    instructionKorean = "다음 설명에 맞는 단어는 무엇입니까?",
                    instructionSinhala = "පහත විස්තරයට ගැළපෙන වචනය කුමක්ද?",
                    passageKorean = "작업장에서 발을 보호하기 위해 신는 신발로, 못이나 무거운 물건이 떨어져도 다치지 않게 철판이 들어 있습니다.",
                    options = listOf(
                        "① 슬리퍼 (සෙරෙප්පු)",
                        "② 운동화 (ක්‍රීඩා සපත්තු)",
                        "③ 안전화 (ආරක්ෂිත සපත්තු)",
                        "④ 장화 (රබර් බූට්)"
                    ),
                    correctOptionIndex = 2,
                    explanationSinhala = "වැඩබිමේදී පාද ආරක්ෂා කර ගැනීමට අඳින, ඇණ හෝ බර ද්‍රව්‍ය වැටුණද තුවාල නොවීමට යකඩ තහඩු යෙදූ සපත්තුව වන්නේ ආරක්ෂිත සපත්තු (안전화) ය. පිළිතුර ③ වේ."
                ),

                // ---- LISTENING (듣기 - Audio Script Played by TTS) ----
                ExamQuestion(
                    id = 107,
                    type = QuestionType.LISTENING,
                    questionNumber = 7,
                    instructionKorean = "[듣기 1] 들은 것을 고르십시오.",
                    instructionSinhala = "[සවන්දීම 1] ඇසෙන වචනය නිවැරදිව තෝරන්න (හඬ පටය අසන්න).",
                    audioScriptKorean = "안전모",
                    passageKorean = "🔊 හඬ පටය ක්‍රියාත්මක කර ඇසෙන වචනය තෝරන්න.",
                    options = listOf(
                        "① 안전대 (ආරක්ෂක පටිය)",
                        "② 안전모 (ආරක්ෂක හෙල්මට් එක)",
                        "③ 안전화 (ආරක්ෂිත සපත්තු)",
                        "④ 보안경 (ආරක්ෂක ඇස් කණ්ණාඩි)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "හඬ පටයෙන් උච්චාරණය කරන්නේ '안전모' (ආරක්ෂක හිස්වැසුම / හෙල්මට්) ය. එබැවින් නිවැරදි පිළිතුර ② වේ."
                ),
                ExamQuestion(
                    id = 108,
                    type = QuestionType.LISTENING,
                    questionNumber = 8,
                    instructionKorean = "[듣기 2] 질문을 듣고 알맞은 대답을 고르십시오.",
                    instructionSinhala = "[සවන්දීම 2] අසන ප්‍රශ්නයට වඩාත්ම සුදුසු පිළිතුර තෝරන්න.",
                    audioScriptKorean = "투안 씨, 언제 한국에 왔어요?",
                    passageKorean = "🔊 ප්‍රශ්නය: 투안 씨, 언제 한국에 왔어요? (තුආන් මහතා, කවදාද කොරියාවට ආවේ?)",
                    options = listOf(
                        "① 작년 7월에 왔어요. (පසුගිය වසරේ ජූලි මාසයේ ආවා)",
                        "② 베트남에서 왔어요. (වියට්නාමයේ සිට ආවා)",
                        "③ 친구하고 같이 왔어요. (මිතුරා සමග එකට ආවා)",
                        "④ 비행기를 타고 왔어요. (ගුවන් යානයෙන් ආවා)"
                    ),
                    correctOptionIndex = 0,
                    explanationSinhala = "ප්‍රශ්නය '언제 한국에 왔어요?' (කවදාද ආවේ?) යනුවෙන් කාලය පිළිබඳව අසන බැවින්, කාලය දක්වන පිළිතුර වන්නේ ① '작년 7월에 왔어요' (පසුගිය වසරේ ජූලි වල ආවා) ය."
                ),
                ExamQuestion(
                    id = 109,
                    type = QuestionType.LISTENING,
                    questionNumber = 9,
                    instructionKorean = "[듣기 3] 대화를 듣고 남자가 해야 할 일을 고르십시오.",
                    instructionSinhala = "[සවන්දීම 3] සංවාදයට සවන් දී පිරිමි පුද්ගලයා කළ යුතු කාර්යය තෝරන්න.",
                    audioScriptKorean = "반장님: 투안 씨, 철사를 잘라야 하니까 창고에 가서 펜치 좀 가져오세요. 투안: 네, 지금 바로 다녀오겠습니다.",
                    passageKorean = "🔊 대화: 반장님이 투안 씨에게 창고에서 펜치를 가져오라고 지시합니다.",
                    options = listOf(
                        "① 기계를 청소한다. (යන්ත්‍රය පිරිසිදු කිරීම)",
                        "② 창고에서 펜치를 가져온다. (ගබඩාවෙන් ප්ලයර් එක රැගෙන ඒම)",
                        "③ 스위치를 누른다. (ස්විචය එබීම)",
                        "④ 병원에 간다. (රෝහලට යාම)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "ෆෝමන් (반장님) උපදෙස් දෙන්නේ කම්බි කැපීම සඳහා ගබඩාවට ගොස් ප්ලයර් එක (펜치) රැගෙන එන ලෙසයි. එබැවින් නිවැරදි පිළිතුර ② වේ."
                ),
                ExamQuestion(
                    id = 110,
                    type = QuestionType.LISTENING,
                    questionNumber = 10,
                    instructionKorean = "[듣기 4] 대화를 듣고 여자가 몇 시에 점심을 먹는지 고르십시오.",
                    instructionSinhala = "[සවන්දීම 4] සංවාදයට සවන් දී කාන්තාව දවල් කෑම කන වේලාව තෝරන්න.",
                    audioScriptKorean = "남: 수루 씨, 몇 시에 점심을 먹어요? 여: 저는 보통 12시 30분에 식당에서 먹어요.",
                    passageKorean = "🔊 대화: 점심 식사 시간을 묻고 답하는 대화입니다.",
                    options = listOf(
                        "① 11시 30분 (11:30)",
                        "② 12시 (12:00)",
                        "③ 12시 30분 (12:30)",
                        "④ 1시 (1:00)"
                    ),
                    correctOptionIndex = 2,
                    explanationSinhala = "කාන්තාව පවසන්නේ '보통 12시 30분에 식당에서 먹어요' (සාමාන්‍යයෙන් 12:30ට කනවා) යනුවෙනි. එබැවින් නිවැරදි පිළිතුර ③ 12:30 වේ."
                )
            )
        ),
        MockExam(
            id = "mock_paper_02",
            paperNumber = 2,
            titleKorean = "제2회 제조업 및 안전수칙 실전 모의고사 (කට්ටලය 02)",
            titleSinhala = "EPS-TOPIK නිෂ්පාදන හා වැඩබිම් ආරක්ෂණ අනුමාන පේපරය 02",
            descriptionSinhala = "නිෂ්පාදන ක්ෂේත්‍රයේ යන්ත්‍ර සූත්‍ර, අනතුරු වැළැක්වීම, ආරක්ෂක උපකරණ සහ හඬ පට අඩංගු විශේෂ පේපරයකි.",
            totalTimeMinutes = 50,
            passMarks = 110,
            totalMarks = 200,
            questions = listOf(
                ExamQuestion(
                    id = 201,
                    type = QuestionType.READING,
                    questionNumber = 1,
                    instructionKorean = "다음 그림에 맞는 기계를 고르십시오.",
                    instructionSinhala = "පහත රූපයට අදාළ යන්ත්‍රය තෝරන්න.",
                    passageKorean = "【 🏗️ 무거운 물건을 싣고 나르는 차량 】",
                    graphicSymbolEmoji = "🚜",
                    options = listOf(
                        "① 지게차 (ෆෝක්ලිෆ්ට් රථය - Forklift)",
                        "② 덤프트럭 (ඩම්ප් ට්‍රක් රථය)",
                        "③ 불도저 (බුල්ඩෝසරය)",
                        "④ 레미콘 (කොන්ක්‍රීට් මිශ්‍රක රථය)"
                    ),
                    correctOptionIndex = 0,
                    explanationSinhala = "කර්මාන්තශාලා හා ගබඩා වල බර පෙට්ටි සහ පලට් එසවීමට සහ ප්‍රවාහනයට යොදා ගන්නා රථය වන්නේ 지게차 (Forklift) ය. නිවැරදි පිළිතුර ① වේ."
                ),
                ExamQuestion(
                    id = 202,
                    type = QuestionType.READING,
                    questionNumber = 2,
                    instructionKorean = "다음 표지의 의미로 알맞은 것을 고르십시오.",
                    instructionSinhala = "පහත ලකුණේ අර්ථය කුමක්ද?",
                    passageKorean = "【 🧯 소화기 (Fire Extinguisher) 】",
                    graphicSymbolEmoji = "🧯",
                    options = listOf(
                        "① 물을 마시는 곳입니다. (ජලය පානය කරන තැනකි)",
                        "② 불이 났을 때 불을 끄는 기구입니다. (ගින්නක් ඇතිවූ විට නිවන උපකරණයකි)",
                        "③ 쓰레기를 버리는 통입니다. (කුණු බහාලන බඳුනකි)",
                        "④ 전기를 켜는 스위치입니다. (විදුලිය දමන ස්විචයකි)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "소화기 යනු ගිනි නිවන උපකරණය (Fire Extinguisher) වේ. ගින්නක් ඇතිවූ විට නිවා දැමීමට එය භාවිතා වේ. නිවැරදි පිළිතුර ② වේ."
                ),
                ExamQuestion(
                    id = 203,
                    type = QuestionType.READING,
                    questionNumber = 3,
                    instructionKorean = "빈칸에 들어갈 가장 알맞은 것을 고르십시오.",
                    instructionSinhala = "හිස්තැනට ගැළපෙන වඩාත්ම නිවැරදි වචනය තෝරන්න.",
                    passageKorean = "용접 작업을 할 때는 불꽃이 튀기 때문에 눈을 보호하기 위해 (      )을 써야 합니다.",
                    options = listOf(
                        "① 보안경 (ආරක්ෂක ඇස් කණ්ණාඩි)",
                        "② 귀마개 (කන් ආවරණ)",
                        "③ 안전화 (ආරක්ෂිත සපත්තු)",
                        "④ 줄자 (මිනුම් පටිය)"
                    ),
                    correctOptionIndex = 0,
                    explanationSinhala = "වෑල්ඩින් කිරීමේදී (용접 작업) ගිනි පුපුරු විසිවන නිසා ඇස් ආරක්ෂා කර ගැනීමට ආරක්ෂක කණ්ණාඩි (보안경) හෝ ආරක්ෂක මුහුණු ආවරණ (보안면) පැළඳිය යුතුය. නිවැරදි පිළිතුර ① වේ."
                ),
                ExamQuestion(
                    id = 204,
                    type = QuestionType.LISTENING,
                    questionNumber = 4,
                    instructionKorean = "[듣기 1] 들은 내용과 같은 것을 고르십시오.",
                    instructionSinhala = "[සවන්දීම] හඬ පටයට සවන් දී ගැළපෙන පිළිතුර තෝරන්න.",
                    audioScriptKorean = "불이 났을 때는 비상벨을 누르고 비상구로 신속하게 대피하십시오.",
                    passageKorean = "🔊 화재 발생 시 대피 요령에 관한 음성 안내입니다.",
                    options = listOf(
                        "① 엘리베이터를 탄다. (විදුලි සෝපානයෙන් යයි)",
                        "② 비상구로 신속하게 대피한다. (හදිසි පිටවීමේ දොරටුවෙන් වහාම ඉවත් වෙයි)",
                        "③ 방에서 문을 닫고 기다린다. (කාමරයේ දොර වසා බලා සිටියි)",
                        "④ 창고에 가서 펜치를 찾는다. (ගබඩාවට ගොස් ප්ලයර් සොයයි)"
                    ),
                    correctOptionIndex = 1,
                    explanationSinhala = "හඬ පටයේ සඳහන් වන්නේ '비상구로 신속하게 대피하십시오' (හදිසි පිටවීමේ දොරටුවෙන් වහාම ඉවත් වන්න) යනුවෙනි. එබැවින් නිවැරදි පිළිතුර ② වේ."
                )
            )
        )
    )
}
