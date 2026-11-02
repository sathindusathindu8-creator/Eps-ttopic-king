package com.example.data

import com.example.model.Dialogue
import com.example.model.DialogueLine
import com.example.model.GrammarExample
import com.example.model.GrammarPoint
import com.example.model.Lesson
import com.example.model.Vocabulary

object EpsBook1Data {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = 6,
            bookId = 1,
            koreanTitle = "제6과 저는 투안입니다",
            sinhalaTitle = "පාඩම 6: මම තුආන් වෙමි",
            englishTitle = "Lesson 6: I am Tuan",
            topicSinhala = "ස්වයං හැඳින්වීම සහ රටවල්/රැකියා (Self Introduction & Occupations)",
            dialogues = listOf(
                Dialogue(
                    id = "d6_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "තුආන් සහ මින්සු අතර පළමු හමුවීම",
                    contextNoteSinhala = "මුලින්ම හමුවූ විට එකිනෙකා හඳුන්වා දෙන ආකාරය",
                    lines = listOf(
                        DialogueLine(1, "민수 (Minsu)", "안녕하세요. 저는 이민수입니다.", "ආයුබෝවන්! මම ලී මින්සු වෙමි.", "අන්‍යොංහසෙයෝ. චොනින් ඉමින්සු ඉම්නිදා."),
                        DialogueLine(2, "투안 (Tuan)", "안녕하세요. 저는 투안입니다.", "ආයුබෝවන්! මම තුආන් වෙමි.", "අන්‍යොංහසෙයෝ. චොනින් තුආන් ඉම්නිදා."),
                        DialogueLine(3, "투안 (Tuan)", "저는 베트남 사람입니다.", "මම වියට්නාම ජාතිකයෙක් වෙමි.", "චොනින් බෙත්නාම් සාරම් ඉම්නිදා.")
                    )
                ),
                Dialogue(
                    id = "d6_2",
                    titleKorean = "대화 2 (සංවාදය 2)",
                    titleSinhala = "තුආන් සහ ජුන් අතර රැකියාව විමසීම",
                    contextNoteSinhala = "රැකියාව සහ ජාතිය ගැන ප්‍රශ්න කිරීම",
                    lines = listOf(
                        DialogueLine(1, "준 (Jun)", "투안 씨는 학생입니까?", "තුආන් මහතා ශිෂ්‍යයෙක්ද?", "තුආන් ෂිනින් හක්සෙන් ඉම්නිකා?"),
                        DialogueLine(2, "투안 (Tuan)", "아니요, 저는 회사원입니다.", "නැත, මම ආයතන සේවකයෙක් වෙමි.", "අනියෝ, චොනින් හ්වේසාවොන් ඉම්නිදා."),
                        DialogueLine(3, "준 (Jun)", "스리랑카 사람입니까?", "ශ්‍රී ලාංකිකයෙක්ද?", "සිරිරංඛා සාරම් ඉම්නිකා?"),
                        DialogueLine(4, "투안 (Tuan)", "아니요, 베트남 사람입니다.", "නැත, වියට්නාම ජාතිකයෙක් වෙමි.", "අනියෝ, බෙත්නාම් සාරම් ඉම්නිදා.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v6_1", "선생님", "ගුරුවරයා", "සොන්සෙන්නිම්", "Teacher", "රැකියා", 6, 1),
                Vocabulary("v6_2", "학생", "ශිෂ්‍යයා", "හක්සෙන්", "Student", "රැකියා", 6, 1),
                Vocabulary("v6_3", "회사원", "ආයතන සේවකයා", "හ්වේසාවොන්", "Company worker", "රැකියා", 6, 1),
                Vocabulary("v6_4", "의사", "වෛද්‍යවරයා", "උයිසා", "Doctor", "රැකියා", 6, 1),
                Vocabulary("v6_5", "간호사", "හෙදිය", "කන්හෝසා", "Nurse", "රැකියා", 6, 1),
                Vocabulary("v6_6", "경찰관", "පොලිස් නිලධාරියා", "ක්‍යොංචල්ග්වාන්", "Police officer", "රැකියා", 6, 1),
                Vocabulary("v6_7", "소방관", "ගිනි නිවන භටයා", "සෝබංග්වාන්", "Firefighter", "රැකියා", 6, 1),
                Vocabulary("v6_8", "농부", "ගොවියා", "නොංබු", "Farmer", "රැකියා", 6, 1),
                Vocabulary("v6_9", "어부", "ධීවරයා", "ඔබු", "Fisherman", "රැකියා", 6, 1),
                Vocabulary("v6_10", "목수", "වඩුවා", "මොක්සු", "Carpenter", "රැකියා", 6, 1),
                Vocabulary("v6_11", "스리랑카", "ශ්‍රී ලංකාව", "සිරිරංඛා", "Sri Lanka", "රටවල්", 6, 1),
                Vocabulary("v6_12", "한국", "කොරියාව", "හන්ගුක්", "Korea", "රටවල්", 6, 1)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g6_1",
                    patternKorean = "-입니다",
                    titleSinhala = "-입니다 (වෙමි / වේ)",
                    ruleExplanationSinhala = "නාම පදයකට පසුව එකතු වන ගෞරවාන්විත ස්වරූපයකි. විධිමත් අවස්ථාවලදී 'මම අසවලා වෙමි' හෝ 'මේ දේ අසවල් දෙයයි' යනුවෙන් ප්‍රකාශ කිරීමට යොදා ගනී.",
                    usageCondition = "නාම පදයේ අවසානයට බච්චිම් (받침) තිබුණද නැතද -입니다 භාවිතා වේ.",
                    examples = listOf(
                        GrammarExample("저는 회사원입니다.", "මම ආයතන සේවකයෙක් වෙමි.", "I am an office worker."),
                        GrammarExample("저는 스리랑카 사람입니다.", "මම ශ්‍රී ලාංකිකයෙක් වෙමි.", "I am Sri Lankan.")
                    )
                ),
                GrammarPoint(
                    id = "g6_2",
                    patternKorean = "-입니까?",
                    titleSinhala = "-입니까? (ද?)",
                    ruleExplanationSinhala = "-입니다 හි ප්‍රශ්නාර්ථ ස්වරූපයයි. ගෞරවාන්විතව 'ඔබ ශිෂ්‍යයෙක්ද?' වැනි ප්‍රශ්න ඇසීමට යොදා ගනී.",
                    usageCondition = "නාම පදයට සෘජුවම -입니까? එකතු වේ.",
                    examples = listOf(
                        GrammarExample("선생님입니까?", "ගුරුවරයෙක්ද?", "Are you a teacher?"),
                        GrammarExample("스리랑카 사람입니까?", "ශ්‍රී ලාංකිකයෙක්ද?", "Are you from Sri Lanka?")
                    )
                )
            ),
            culturalNoteSinhala = "කොරියානු සංස්කෘතියේ ආචාර කිරීම (인사 예절): කොරියාවේ හමුවූ විට අත් දෙක එකතු කර හෝ ඇඟ ඉදිරියට නමා (30-45 අංශක) ආචාර කිරීම සිරිතයි. වැඩිහිටියන්ට හෝ සේවා ස්ථානයේ ඉහළ නිලධාරීන්ට අත් දෙකෙන්ම ආචාර කර ගෞරවය දැක්විය යුතුය."
        ),
        Lesson(
            id = 7,
            bookId = 1,
            koreanTitle = "제7과 여기가 사무실이에요",
            sinhalaTitle = "පාඩම 7: මෙතන කාර්යාලයයි",
            englishTitle = "Lesson 7: This is the office",
            topicSinhala = "ස්ථාන සහ දෛනික භාණ්ඩ (Places & Everyday Objects)",
            dialogues = listOf(
                Dialogue(
                    id = "d7_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "වැඩබිමේ කාර්යාලය පෙන්වීම",
                    contextNoteSinhala = "කාර්යාලය සහ නවාතැන්පල හඳුනා ගැනීම",
                    lines = listOf(
                        DialogueLine(1, "민수 (Minsu)", "여기가 사무실입니까?", "මෙතන කාර්යාලයද?", "යොගිගා සාමුශිල් ඉම්නිකා?"),
                        DialogueLine(2, "투안 (Tuan)", "네, 사무실입니다.", "ඔව්, කාර්යාලයයි.", "නේ, සාමුශිල් ඉම්නිදා."),
                        DialogueLine(3, "민수 (Minsu)", "화장실이 어디입니까?", "වැසිකිළිය කොහේද?", "හ්වාජංශිල්-ඉ ඔඩිඉම්නිකා?"),
                        DialogueLine(4, "투안 (Tuan)", "저기입니다.", "අර එහේය.", "චොගි ඉම්නිදා.")
                    )
                ),
                Dialogue(
                    id = "d7_2",
                    titleKorean = "대화 2 (සංවාදය 2)",
                    titleSinhala = "නවාතැන්පලේ භාණ්ඩ විමසීම",
                    contextNoteSinhala = "යතුර සහ විදේශික ලියාපදිංචි කාඩ්පත",
                    lines = listOf(
                        DialogueLine(1, "리한 (Rihan)", "여기가 기숙사예요.", "මෙතන නේවාසිකාගාරයයි.", "යොගිගා කිසුක්සායෙයෝ."),
                        DialogueLine(2, "투안 (Tuan)", "이게 기숙사 열쇠예요?", "මේක නේවාසිකාගාර යතුරද?", "ඉගේ කිසුක්සා යොල්ස්වේයෙයෝ?"),
                        DialogueLine(3, "리한 (Rihan)", "네, 맞아요. 그리고 이건 외국인등록증이에요.", "ඔව්, හරි. තවද මේක විදේශික ලියාපදිංචි කාඩ්පතයි.", "නේ, මාජායෝ. කුරිගෝ ඉගොන් වේගුගින් දුංරොක්ජුං ඉඑයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v7_1", "사무실", "කාර්යාලය", "සාමුශිල්", "Office", "ස්ථාන", 7, 1),
                Vocabulary("v7_2", "기숙사", "නේවාසිකාගාරය / බෝඩිම", "කිසුක්සා", "Dormitory", "ස්ථාන", 7, 1),
                Vocabulary("v7_3", "화장실", "වැසිකිළිය", "හ්වාජංශිල්", "Restroom / Toilet", "ස්ථාන", 7, 1),
                Vocabulary("v7_4", "식당", "ආපනශාලාව / රෙස්ටුරන්ට් එක", "ශික්දං", "Cafeteria / Restaurant", "ස්ථාන", 7, 1),
                Vocabulary("v7_5", "열쇠", "යතුර", "යොල්ස්වේ", "Key", "භාණ්ඩ", 7, 1),
                Vocabulary("v7_6", "외국인등록증", "විදේශික ලියාපදිංචි කාඩ්පත", "වේගුගින් දුංරොක්ජුං", "Alien Registration Card", "භාණ්ඩ", 7, 1),
                Vocabulary("v7_7", "이불", "ඇඳ ඇතිරිල්ල / රෙද්ද", "ඉබුල්", "Blanket", "භාණ්ඩ", 7, 1),
                Vocabulary("v7_8", "베개", "කොට්ටය", "බෙගේ", "Pillow", "භාණ්ඩ", 7, 1),
                Vocabulary("v7_9", "치약", "දත් බෙහෙත්", "චියාක්", "Toothpaste", "භාණ්ඩ", 7, 1),
                Vocabulary("v7_10", "칫솔", "දත් බුරුසුව", "චිත්සොල්", "Toothbrush", "භාණ්ඩ", 7, 1)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g7_1",
                    patternKorean = "-이/가",
                    titleSinhala = "-이/가 (උක්ත ප්‍රත්‍යය / Subject Marker)",
                    ruleExplanationSinhala = "වාක්‍යයක කර්තෘ හෝ උක්තය හඳුන්වා දීමට නාම පදයට පසුව යොදා ගනී.",
                    usageCondition = "අවසානයට බච්චිම් (받침) ඇත්නම් -이, බච්චිම් නැත්නම් -가 එකතු වේ.",
                    examples = listOf(
                        GrammarExample("사무실이 어디입니까?", "කාර්යාලය කොහේද?", "Where is the office?"),
                        GrammarExample("여기가 기숙사입니다.", "මෙතන නේවාසිකාගාරයයි.", "Here is the dormitory.")
                    )
                ),
                GrammarPoint(
                    id = "g7_2",
                    patternKorean = "-이에요/예요",
                    titleSinhala = "-이에요/예요 (වෙයි / වේ - මිත්‍රශීලී අවසානය)",
                    ruleExplanationSinhala = "දෛනික සුහද කතාබහේදී 'වේ / ය' යන අර්ථයෙන් නාම පද අවසානයට එකතු වේ.",
                    usageCondition = "බච්චිම් ඇත්නම් -이에요, බච්චිම් නැත්නම් -예요 යෙදේ.",
                    examples = listOf(
                        GrammarExample("여기가 기숙사예요.", "මෙතන නේවාසිකාගාරයයි.", "This is the dorm."),
                        GrammarExample("가방이에요.", "බෑගයයි.", "It's a bag.")
                    )
                )
            ),
            culturalNoteSinhala = "කොරියාවේ නේවාසිකාගාර (기숙사 생활): බොහෝ කර්මාන්තශාලා වල විදේශික ශ්‍රමිකයින්ට නේවාසිකාගාර පහසුකම් සපයයි. කාමරය තුළ පාවහන් ගැලවීම අනිවාර්ය වන අතර, පොදු ශීතකරණ හා නාන කාමර පිරිසිදුව තබා ගැනීම වැදගත් වේ."
        ),
        Lesson(
            id = 8,
            bookId = 1,
            koreanTitle = "제8과 12시 30분에 점심을 먹어요",
            sinhalaTitle = "පාඩම 8: 12.30 ට දවල් කෑම කනවා",
            englishTitle = "Lesson 8: I eat lunch at 12:30",
            topicSinhala = "දෛනික චර්යාව සහ වේලාව (Daily Routine & Time)",
            dialogues = listOf(
                Dialogue(
                    id = "d8_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "තුආන්ගේ දෛනික වැඩසටහන",
                    contextNoteSinhala = "දැන් කරන කාර්යයන් ගැන කතා කිරීම",
                    lines = listOf(
                        DialogueLine(1, "투안 (Tuan)", "지금 뭐 해요?", "දැන් මොකද කරන්නේ?", "චිගුම් ම්වෝ හෙයෝ?"),
                        DialogueLine(2, "리한 (Rihan)", "텔레비전을 봐요. 투안 씨는요?", "ටෙලිවිෂන් බලනවා. තුආන් මහතා මොකද කරන්නේ?", "තෙල්ලෙබිජොනොල් බ්වායෝ. තුආන් ෂිනින්යෝ?"),
                        DialogueLine(3, "투안 (Tuan)", "저는 지금 요리해요.", "මම දැන් කෑම උයනවා.", "චොනින් චිගුම් යෝරිහෙයෝ.")
                    )
                ),
                Dialogue(
                    id = "d8_2",
                    titleKorean = "대화 2 (සංවාදය 2)",
                    titleSinhala = "වැඩ නිමවන වේලාව විමසීම",
                    contextNoteSinhala = "කර්මාන්තශාලාවේ වැඩ අරඹන සහ නිමවන වේලාව",
                    lines = listOf(
                        DialogueLine(1, "투안 (Tuan)", "지금 몇 시예요?", "දැන් වෙලාව කීයද?", "චිගුම් ම්යොත් ශියෙයෝ?"),
                        DialogueLine(2, "리한 (Rihan)", "11시예요.", "11යි.", "යොල්හන් ශියෙයෝ."),
                        DialogueLine(3, "투안 (Tuan)", "몇 시에 점심을 먹어요?", "කීයටද දවල් කෑම කන්නේ?", "ම්යොත් ශියේ චොම්ශිමොල් මොගොයෝ?"),
                        DialogueLine(4, "리한 (Rihan)", "12시 30분에 먹어요.", "12.30 ට කනවා.", "යොල්දු ශි සම්ශිබ්බුනේ මොගොයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v8_1", "일어나다", "නැගිටිනවා", "ඉරොනාදා", "To wake up", "ක්‍රියාපද", 8, 1),
                Vocabulary("v8_2", "씻다", "සේදෙනවා / මුහුණ සෝදනවා", "ශිත්තා", "To wash", "ක්‍රියාපද", 8, 1),
                Vocabulary("v8_3", "출근하다", "වැඩට යනවා (Shift Start)", "චුල්ගුන්හාදා", "To go to work", "ක්‍රියාපද", 8, 1),
                Vocabulary("v8_4", "퇴근하다", "වැඩ ඇරී එනවා (Shift End)", "ත්වේගුන්හාදා", "To get off work", "ක්‍රියාපද", 8, 1),
                Vocabulary("v8_5", "자다", "නිදාගන්නවා", "චාදා", "To sleep", "ක්‍රියාපද", 8, 1),
                Vocabulary("v8_6", "점심", "දවල් ආහාරය", "චොම්ශිම්", "Lunch", "වේලාව", 8, 1),
                Vocabulary("v8_7", "아침", "උදෑසන / උදෑසන ආහාරය", "ආචිම්", "Morning / Breakfast", "වේලාව", 8, 1),
                Vocabulary("v8_8", "저녁", "සවස / රාත්‍රී ආහාරය", "චොන්‍යොක්", "Evening / Dinner", "වේලාව", 8, 1),
                Vocabulary("v8_9", "밤", "රාත්‍රිය", "බම්", "Night", "වේලාව", 8, 1),
                Vocabulary("v8_10", "새벽", "පාන්දර", "සැබ්යොක්", "Dawn", "වේලාව", 8, 1)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g8_1",
                    patternKorean = "-아/어요",
                    titleSinhala = "-아/어요 (වර්තමාන කාල සුහද ක්‍රියා අවසානය)",
                    ruleExplanationSinhala = "ක්‍රියාපද සහ විශේෂණ පද වර්තමාන කාලයෙන් ප්‍රකාශ කිරීමට යොදා ගනී.",
                    usageCondition = "ක්‍රියා ධාතුවේ අවසන් ස්වරය ㅏ හෝ ㅗ නම් -아요, අනෙකුත් ස්වර නම් -어요, 하다 නම් 해요 බවට පත්වේ.",
                    examples = listOf(
                        GrammarExample("텔레비전을 봐요.", "රූපවාහිනිය බලනවා.", "I watch TV."),
                        GrammarExample("밥을 먹어요.", "බත් කනවා.", "I eat rice."),
                        GrammarExample("일해요.", "වැඩ කරනවා.", "I work.")
                    )
                ),
                GrammarPoint(
                    id = "g8_2",
                    patternKorean = "-에 (시간)",
                    titleSinhala = "-에 (වේලාව සමග - ට / දී)",
                    ruleExplanationSinhala = "යම් ක්‍රියාවක් සිදුවන වේලාව හෝ දිනය නිරූපණය කිරීමට යොදා ගනී.",
                    usageCondition = "වේලාව දැක්වෙන නාම පදයට පසුව -에 එකතු වේ. (දැන් - 지금, ඊයේ - 어제 වැනි වචන වලට -에 යෙදෙන්නේ නැත).",
                    examples = listOf(
                        GrammarExample("12시 30분에 먹어요.", "12.30 ට කනවා.", "I eat at 12:30."),
                        GrammarExample("아침에 운동해요.", "උදෑසනට ව්‍යායාම කරනවා.", "I exercise in the morning.")
                    )
                )
            ),
            culturalNoteSinhala = "කොරියාවේ කාල කළමනාකරණය සහ වේලාවට වැඩ කිරීම (출근 시간 지키기): කොරියානු වැඩබිම් වල වැඩ ආරම්භ වීමට අවම වශයෙන් විනාඩි 10 කට පෙරවත් පැමිණ සූදානම් විය යුතුය. වේලාවට වැඩ කිරීම (Punctuality) රැකියාවේ අතිශය තීරණාත්මක සාධකයකි."
        ),
        Lesson(
            id = 11,
            bookId = 1,
            koreanTitle = "제11과 사과 다섯 개 주세요",
            sinhalaTitle = "පාඩම 11: ඇපල් ගෙඩි පහක් දෙන්න",
            englishTitle = "Lesson 11: Please give me five apples",
            topicSinhala = "බඩු මිලදී ගැනීම සහ ගණන් කිරීමේ ඒකක (Shopping & Counters)",
            dialogues = listOf(
                Dialogue(
                    id = "d11_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "පලතුරු මිලදී ගැනීම",
                    contextNoteSinhala = "පලතුරු වෙළඳසැලකදී මිල විමසීම",
                    lines = listOf(
                        DialogueLine(1, "주인 (Shopkeeper)", "어서 오세요.", "සාදරයෙන් පිළිගනිමු!", "ඔසෝ ඕසෙයෝ."),
                        DialogueLine(2, "투안 (Tuan)", "안녕하세요? 이 사과 얼마예요?", "ආයුබෝවන්? මේ ඇපල් කීයද?", "අන්‍යොංහසෙයෝ? ඉ සාග්වා ඔල්මායෙයෝ?"),
                        DialogueLine(3, "주인 (Shopkeeper)", "이천 원이에요.", "වොන් දෙදහසයි (2,000₩).", "ඉචොන් වොනියෙයෝ."),
                        DialogueLine(4, "투안 (Tuan)", "다섯 개 주세요.", "පහක් දෙන්න.", "තසොත් කේ චුසෙයෝ.")
                    )
                ),
                Dialogue(
                    id = "d11_2",
                    titleKorean = "대화 2 (සංවාදය 2)",
                    titleSinhala = "සපත්තු මිලදී ගැනීම සහ මුදල් ගෙවීම",
                    contextNoteSinhala = "වට්ටමක් ඉල්ලීම සහ කාඩ්පතින් ගෙවීම",
                    lines = listOf(
                        DialogueLine(1, "투안 (Tuan)", "이 운동화 얼마예요?", "මේ සපත්තු ජෝඩුව කීයද?", "ඉ උන්දොංහ්වා ඔල්මායෙයෝ?"),
                        DialogueLine(2, "주인 (Shopkeeper)", "오만 오천 원이에요.", "වොන් පනස් පන්දහසයි (55,000₩).", "ඕමන් ඕචොන් වොනියෙයෝ."),
                        DialogueLine(3, "투안 (Tuan)", "오만 오천 원이요? 좀 깎아 주세요.", "55,000 ක්ද? ටිකක් අඩු කර දෙන්නකෝ.", "ඕමන් ඕචොන් වොනියෝ? චොම් කක්කා චුසෙයෝ."),
                        DialogueLine(4, "주인 (Shopkeeper)", "그래요. 오만 원 주세요.", "හරි, වොන් පනස්දහසක් (50,000₩) දෙන්න.", "කුරෙයෝ. ඕමන් වොන් චුසෙයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v11_1", "사과", "ඇපල්", "සාග්වා", "Apple", "පලතුරු", 11, 1),
                Vocabulary("v11_2", "오렌지", "දොඩම්", "ඔරෙන්ජි", "Orange", "පලතුරු", 11, 1),
                Vocabulary("v11_3", "포도", "මිදි", "පෝදෝ", "Grapes", "පලතුරු", 11, 1),
                Vocabulary("v11_4", "개", "ගෙඩි / කෑලි (සාමාන්‍ය ගණන් කිරීමේ ඒකකය)", "කේ", "Counter for general items", "ඒකක", 11, 1),
                Vocabulary("v11_5", "명 / 분", "පුද්ගලයින් (කී දෙනෙක්ද)", "ම්යොං / බුන්", "Counter for people", "ඒකක", 11, 1),
                Vocabulary("v11_6", "마리", "සතුන් ගණන් කිරීමේ ඒකකය", "මාරි", "Counter for animals", "ඒකක", 11, 1),
                Vocabulary("v11_7", "병", "බෝතල් ගණන් කිරීමේ ඒකකය", "බ්යොං", "Counter for bottles", "ඒකක", 11, 1),
                Vocabulary("v11_8", "잔", "කෝප්ප ගණන් කිරීමේ ඒකකය", "චන්", "Counter for cups", "ඒකක", 11, 1),
                Vocabulary("v11_9", "원", "වොන් (කොරියානු මුදල් ඒකකය)", "වොන්", "Korean Won (KRW)", "මුදල්", 11, 1),
                Vocabulary("v11_10", "현금", "මුදල් නෝට්ටු (Cash)", "හ්යොන්ගුම්", "Cash", "මුදල්", 11, 1),
                Vocabulary("v11_11", "신용카드", "ණයපත් (Credit Card)", "ශින්‍යොං කාදු", "Credit Card", "මුදල්", 11, 1)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g11_1",
                    patternKorean = "-주세요",
                    titleSinhala = "-주세요 (කරුණාකර දෙන්න / කරන්න)",
                    ruleExplanationSinhala = "යම් දෙයක් ඉල්ලා සිටින විට හෝ නියෝගයක් ආචාරශීලීව කරන විට යොදා ගනී.",
                    usageCondition = "නාම පද සමග සෘජුව හෝ ක්‍රියාපද (아/어 보세요 / 주세요) සමග යෙදේ.",
                    examples = listOf(
                        GrammarExample("물 좀 주세요.", "වතුර ටිකක් දෙන්න.", "Please give me some water."),
                        GrammarExample("사과 다섯 개 주세요.", "ඇපල් පහක් දෙන්න.", "Please give me 5 apples.")
                    )
                ),
                GrammarPoint(
                    id = "g11_2",
                    patternKorean = "-아/어 주세요",
                    titleSinhala = "-아/어 주세요 (කරුණාකර කර දෙන්න)",
                    ruleExplanationSinhala = "තමා වෙනුවෙන් යම් ක්‍රියාවක් කර දෙන ලෙස ඉල්ලා සිටින විට ක්‍රියාපදයට සම්බන්ධ වේ.",
                    usageCondition = "깎다 (අඩු කරනවා) -> 깎아 주세요 (අඩු කර දෙන්න), 돕다 (උදව් කරනවා) -> 도와주세요 (උදව් කරන්න).",
                    examples = listOf(
                        GrammarExample("좀 깎아 주세요.", "ටිකක් අඩු කර දෙන්න.", "Please give me a discount."),
                        GrammarExample("가방을 들어 주세요.", "බෑගය ඔසවා දෙන්න.", "Please carry my bag.")
                    )
                )
            ),
            culturalNoteSinhala = "කොරියානු මුදල් (화폐): කොරියාවේ කාසි (동전: 10원, 50원, 100원, 500원) සහ නෝට්ටු (지폐: 1,000원, 5,000원, 10,000원, 50,000원) භාවිතා වේ. වෙළඳපොලේදී බඩු මිලදී ගැනීමේදී මුදල් හෝ ක්‍රෙඩිට් කාඩ් පත් අත් දෙකෙන්ම ලබා දීම ගෞරවනීය සිරිතකි."
        ),
        Lesson(
            id = 26,
            bookId = 1,
            koreanTitle = "제26과 밥을 먹은 후에 이 약을 드세요",
            sinhalaTitle = "පාඩම 26: කෑම කෑවාට පසු මේ බෙහෙත බොන්න",
            englishTitle = "Lesson 26: Take this medicine after meals",
            topicSinhala = "ශරීර අවයව, රෝග ලක්ෂණ සහ රෝහල්/ෆාමසි (Body, Symptoms & Medicine)",
            dialogues = listOf(
                Dialogue(
                    id = "d26_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "ෆාමසියෙන් බෙහෙත් ගැනීම",
                    contextNoteSinhala = "බඩේ අමාරුව සහ ඖෂධ උපදෙස්",
                    lines = listOf(
                        DialogueLine(1, "약사 (Pharmacist)", "어떻게 오셨어요?", "මොන කරුණකටද ආවේ? (කොහොමද උදව් කරන්නේ?)", "ඔත්තොකේ ඕෂොස්සොයෝ?"),
                        DialogueLine(2, "바루 (Baru)", "머리가 아프고 열이 나요.", "හිස කැක්කුමයි උණත් තියෙනවා.", "මොරිගා ආප්‍යුගෝ යොරි නායෝ."),
                        DialogueLine(3, "약사 (Pharmacist)", "언제부터 그래요?", "කවදා සිටද මෙහෙම වෙන්නේ?", "ඔන්ජෙබුතෝ කුරෙයෝ?"),
                        DialogueLine(4, "바루 (Baru)", "어제 밤부터요. 배도 아파요.", "ඊයේ රෑ ඉඳලා. බඩත් රිදෙනවා.", "ඔජේ බම්බුතෝයෝ. බේදෝ ආපායෝ."),
                        DialogueLine(5, "약사 (Pharmacist)", "밥을 먹은 후에 이 약을 드세요.", "කෑම කෑවාට පසු මේ ඖෂධය ලබාගන්න.", "බාබොල් මොගුන් හූයේ ඉ යාගොල් දුසෙයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v26_1", "머리", "හිස", "මොරි", "Head", "ශරීරය", 26, 1),
                Vocabulary("v26_2", "배", "බඩ", "බේ", "Stomach", "ශරීරය", 26, 1),
                Vocabulary("v26_3", "눈", "ඇස", "නුන්", "Eye", "ශරීරය", 26, 1),
                Vocabulary("v26_4", "감기", "හෙම්බිරිස්සාව / උණ", "කම්ගි", "Cold / Flu", "රෝග ලක්ෂණ", 26, 1),
                Vocabulary("v26_5", "열이 나다", "උණ හැදෙනවා", "යොරි නාදා", "To have a fever", "රෝග ලක්ෂණ", 26, 1),
                Vocabulary("v26_6", "기침을 하다", "කැස්ස හැදෙනවා", "කිචිමොල් හාදා", "To cough", "රෝග ලක්ෂණ", 26, 1),
                Vocabulary("v26_7", "설사를 하다", "බඩ බුරුල් වෙනවා (Diarrhea)", "සොල්සාරොල් හාදා", "To have diarrhea", "රෝග ලක්ෂණ", 26, 1),
                Vocabulary("v26_8", "약국", "ෆාමසිය", "යාක්ගුක්", "Pharmacy", "ස්ථාන", 26, 1),
                Vocabulary("v26_9", "병원", "රෝහල", "බ්යොංවොන්", "Hospital", "ස්ථාන", 26, 1),
                Vocabulary("v26_10", "진통제", "වේදනා නාශක ඖෂධ", "ජින්තොංජේ", "Painkiller", "ඖෂධ", 26, 1)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g26_1",
                    patternKorean = "-(으)ㄴ 후에",
                    titleSinhala = "-(으)ㄴ 후에 (... කළාට පසු / After doing)",
                    ruleExplanationSinhala = "යම් ක්‍රියාවක් සිදු කිරීමෙන් අනතුරුව තවත් ක්‍රියාවක් සිදුවන බව දැක්වීමට යොදා ගනී.",
                    usageCondition = "ක්‍රියා ධාතුවට බච්චිම් ඇත්නම් -은 후에, නැත්නම් -ㄴ 후에 යෙදේ.",
                    examples = listOf(
                        GrammarExample("밥을 먹은 후에 약을 드세요.", "කෑම කෑවාට පසු බෙහෙත් බොන්න.", "Take medicine after eating."),
                        GrammarExample("일이 끝난 후에 만나요.", "වැඩ ඉවර වුණාට පසු හමුවෙමු.", "Let's meet after work ends.")
                    )
                ),
                GrammarPoint(
                    id = "g26_2",
                    patternKorean = "-지 마세요",
                    titleSinhala = "-지 마세요 (... කරන්න එපා / Please don't)",
                    ruleExplanationSinhala = "යම් දෙයක් නොකරන ලෙස ආචාරශීලීව තහනම් කිරීමට හෝ අවවාද කිරීමට යොදා ගනී.",
                    usageCondition = "ක්‍රියා ධාතුවට කෙලින්ම -지 마세요 එකතු වේ.",
                    examples = listOf(
                        GrammarExample("찬 물을 마시지 마세요.", "ශීතල වතුර බොන්න එපා.", "Do not drink cold water."),
                        GrammarExample("담배를 피우지 마세요.", "දුම්බොන්න එපා.", "Do not smoke.")
                    )
                )
            ),
            culturalNoteSinhala = "කොරියාවේ ඖෂධ සහ හදිසි ප්‍රතිකාර: සති අන්තයේ හෝ රාත්‍රී කාලයේ ෆාමසි වසා ඇති විට සාමාන්‍ය වේදනා නාශක, සෙම්ප්‍රතිශ්‍යාව සඳහා බෙහෙත් සහ පැලැස්ටර් පැය 24 පුරා ක්‍රියාත්මක වන පහසුකම් වෙළඳසැල් වලින් (편의점: GS25, CU, 7-Eleven) මිලදී ගත හැකිය."
        )
    )
}
