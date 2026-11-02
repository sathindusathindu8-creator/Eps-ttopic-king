package com.example.data

import com.example.model.Dialogue
import com.example.model.DialogueLine
import com.example.model.GrammarExample
import com.example.model.GrammarPoint
import com.example.model.Lesson
import com.example.model.Vocabulary

object EpsBook2Data {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = 41,
            bookId = 2,
            koreanTitle = "제41과 펜치로 철사를 잘라요",
            sinhalaTitle = "පාඩම 41: ප්ලයර් එකෙන් කම්බි කපනවා",
            englishTitle = "Lesson 41: Cut the wire with pliers",
            topicSinhala = "නිෂ්පාදන සහ අත් ආයුධ භාවිතය (Manufacturing & Hand Tools)",
            dialogues = listOf(
                Dialogue(
                    id = "d41_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "වැඩබිමේදී අත් ආයුධ ඉල්ලා ගැනීම",
                    contextNoteSinhala = "කර්මාන්තශාලාවේදී බන්ජංනිම් (ෆෝමන්) සමග සංවාදය",
                    lines = listOf(
                        DialogueLine(1, "철민 (Cheolmin)", "투안 씨, 펜치 좀 가져다주세요.", "තුආන් මහතා, කරුණාකර ප්ලයර් එක අරන් දෙන්න.", "තුආන් ෂි, පෙන්චි චොම් කාජ්යොදාජුසෙයෝ."),
                        DialogueLine(2, "투안 (Tuan)", "네, 여기 있어요. 그런데 펜치로 뭘 해요?", "ඔව්, මෙන්න මෙතන තියෙනවා. ඒත් ප්ලයර් එකෙන් මොනවද කරන්නේ?", "නේ, යොගි ඉස්සොයෝ. කුරොන්දේ පෙන්චිරෝ ම්වොල් හෙයෝ?"),
                        DialogueLine(3, "철민 (Cheolmin)", "철사를 자르고 구부려야 해요.", "කම්බිය කපලා නවන්න ඕනේ.", "චොල්සාරොල් චාරුගෝ කුබුර්යෝයා හෙයෝ."),
                        DialogueLine(4, "투안 (Tuan)", "니퍼도 필요하지 않아요?", "කටර් (Nipper) එකත් ඕන නැද්ද?", "නිපොදෝ පිල්යෝහාජි ආනායෝ?"),
                        DialogueLine(5, "철민 (Cheolmin)", "네, 니퍼도 같이 주세요.", "ඔව්, නිපර් එකත් එක්කම දෙන්න.", "නේ, නිපොදෝ කාචි චුසෙයෝ.")
                    )
                ),
                Dialogue(
                    id = "d41_2",
                    titleKorean = "대화 2 (සංවාදය 2)",
                    titleSinhala = "බොල්ට් සහ නට් තද කිරීම",
                    contextNoteSinhala = "ස්පැනර් සහ ස්ක්‍රූ ඩ්‍රයිවර් භාවිතය",
                    lines = listOf(
                        DialogueLine(1, "반장님 (Foreman)", "공구함에 스패너가 있어요?", "ටූල් බොක්ස් එකේ ස්පැනර් එකක් තියෙනවද?", "කොංගුහාමේ සුපැනෝගා ඉස්සොයෝ?"),
                        DialogueLine(2, "바루 (Baru)", "아니요, 없는데요. 드라이버만 있어요.", "නැත, නැහැ. ස්ක්‍රූ ඩ්‍රයිවර් එක විතරයි තියෙන්නේ.", "අනියෝ, ඔම්නුන්දෙයෝ. දුරායිබෝමන් ඉස්සොයෝ."),
                        DialogueLine(3, "반장님 (Foreman)", "그럼 옆 작업장에서 빌려오세요.", "එහෙනම් එහා පැත්තේ වැඩබිමෙන් ණයට ඉල්ලාගෙන එන්න.", "කුරොම් යොප් චාගොප්ජං-එසෝ බිල්ල්යෝඕසෙයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v41_1", "펜치", "ප්ලයර් එක", "පෙන්චි", "Pliers", "ආයුධ", 41, 2),
                Vocabulary("v41_2", "니퍼", "කටරය (කම්බි කපන)", "නිපෝ", "Nippers / Cutting pliers", "ආයුධ", 41, 2),
                Vocabulary("v41_3", "플라이어", "වයිස් ප්ලයර් එක", "පුල්ලායියෝ", "Pliers / Vice grip", "ආයුධ", 41, 2),
                Vocabulary("v41_4", "드라이버", "ස්ක්‍රූ ඩ්‍රයිවර් එක", "දුරායිබෝ", "Screwdriver", "ආයුධ", 41, 2),
                Vocabulary("v41_5", "스패너 / 렌치", "ස්පැනරය / රෙන්ච් එක", "සුපැනෝ / රෙන්චි", "Spanner / Wrench", "ආයුධ", 41, 2),
                Vocabulary("v41_6", "망치", "මිටිය", "මංචි", "Hammer", "ආයුධ", 41, 2),
                Vocabulary("v41_7", "톱", "කියත", "තොප්", "Saw", "ආයුධ", 41, 2),
                Vocabulary("v41_8", "못", "ඇණය", "මොත්", "Nail", "උපාංග", 41, 2),
                Vocabulary("v41_9", "나사못", "ස්කුරුප්පු ඇණය (Screw)", "නාසාමොත්", "Screw", "උපාංග", 41, 2),
                Vocabulary("v41_10", "볼트 / 너트", "බෝල්ට් / නට් ඇණ", "බෝල්තු / නොතු", "Bolt and Nut", "උපාංග", 41, 2),
                Vocabulary("v41_11", "전기드릴", "විදුලි ඩ්‍රිල් යන්ත්‍රය", "චොන්ගි දුරිල්", "Electric Drill", "ආයුධ", 41, 2),
                Vocabulary("v41_12", "줄자", "මිනුම් පටිය (Measuring Tape)", "චුල්ජා", "Tape Measure", "ආයුධ", 41, 2)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g41_1",
                    patternKorean = "-(으)로 (도구)",
                    titleSinhala = "-(으)로 (උපකරණ / මාධ්‍යය - මඟින් / ආධාරයෙන්)",
                    ruleExplanationSinhala = "යම් කාර්යයක් කිරීමට භාවිතා කරන මෙවලම හෝ ක්‍රමය හැඟවීමට යොදා ගනී.",
                    usageCondition = "නාම පදයට බච්චිම් ඇත්නම් -으로 (ㄹ හැර), බච්චිම් නැත්නම් හෝ ㄹ බච්චිම් ඇත්නම් -로 යෙදේ.",
                    examples = listOf(
                        GrammarExample("펜치로 철사를 잘라요.", "ප්ලයර් එකෙන් කම්බි කපනවා.", "Cut wire with pliers."),
                        GrammarExample("칼로 종이를 잘라요.", "පිහියෙන් කොළය කපනවා.", "Cut paper with a knife.")
                    )
                ),
                GrammarPoint(
                    id = "g41_2",
                    patternKorean = "-고 있다",
                    titleSinhala = "-고 있다 (කරමින් පවතිනවා / Present Continuous)",
                    ruleExplanationSinhala = "වර්තමානයේ සිදුවෙමින් පවතින ක්‍රියාවක් විස්තර කිරීමට යොදා ගනී.",
                    usageCondition = "ක්‍රියා ධාතුවට කෙලින්ම -고 있다 සම්බන්ධ වේ.",
                    examples = listOf(
                        GrammarExample("지금 조립하고 있어요.", "දැන් එකලස් කරමින් සිටිනවා.", "I am assembling right now."),
                        GrammarExample("작업을 하고 있어요.", "වැඩ කරමින් සිටිනවා.", "I am working.")
                    )
                )
            ),
            culturalNoteSinhala = "වැඩබිමේ මෙවලම් නඩත්තුව (공구 관리): භාවිතා කළ උපකරණ වැඩ අවසන් වූ වහාම පිරිසිදු කර නියමිත ආයුධ පෙට්ටියේ (공구함) හෝ රාක්කයේ පිළිවෙලට තැබිය යුතුය. නොසැලකිලිමත් ලෙස බිම තැබීම අනතුරු ඇතිවීමට ප්‍රධාන හේතුවකි."
        ),
        Lesson(
            id = 48,
            bookId = 2,
            koreanTitle = "제48과 다치지 않도록 조심하세요",
            sinhalaTitle = "පාඩම 48: තුවාල නොවෙන්න පරිස්සම් වන්න",
            englishTitle = "Lesson 48: Be careful not to get hurt",
            topicSinhala = "වැඩබිමේ අනතුරු සහ ආරක්ෂණ උපදෙස් (Workplace Safety & Hazard Prevention)",
            dialogues = listOf(
                Dialogue(
                    id = "d48_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "යන්ත්‍රයක් ක්‍රියාත්මක කිරීමේදී අනතුරු වළක්වා ගැනීම",
                    contextNoteSinhala = "ප්‍රෙස් මැෂින් (Press Machine) සහ කැපුම් උපකරණ",
                    lines = listOf(
                        DialogueLine(1, "반장님 (Foreman)", "투안 씨, 프레스 작업할 때 손 조심하세요.", "තුආන් මහතා, ප්‍රෙස් යන්ත්‍රයේ වැඩ කරන විට අත් පරිස්සම් කරගන්න.", "තුආන් ෂි, පුරේසු චාගොප්හල් තේ සොන් චෝශිම්හාසෙයෝ."),
                        DialogueLine(2, "투안 (Tuan)", "네, 반장님. 스위치를 발로 밟을 때 항상 조심하고 있어요.", "එහෙමයි සර්. ස්විචය පයින් පාගන විට නිතරම පරිස්සම් වෙනවා.", "නේ, බන්ජංනිම්. සුවිචිරොල් බල්රෝ බල්බුල් තේ හංසං චෝශිම්හාගෝ ඉස්සොයෝ."),
                        DialogueLine(3, "반장님 (Foreman)", "집게를 사용해서 물건을 넣으세요. 손을 넣으면 큰일 나요.", "අඬුව (Tongs) පාවිච්චි කරලා භාණ්ඩය ඇතුලට දමන්න. අත දැම්මොත් ලොකු විපතක් වෙයි.", "චිප්ගෙරොල් සයොංහෙස්සෝ මුල්ගොනොල් නොහුසෙයෝ. සොනොල් නොහූමියොන් කූනිල් නායෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v48_1", "감전되다", "විදුලි සැර වදිනවා", "කම්ජොන්දුවේදා", "To get electric shock", "අනතුරු", 48, 2),
                Vocabulary("v48_2", "화상을 입다", "පිලිස්සුම් තුවාල වෙනවා", "හ්වාසාංගොල් ඉප්තා", "To get burned", "අනතුරු", 48, 2),
                Vocabulary("v48_3", "손가락이 베이다", "ඇඟිල්ල කැපෙනවා", "සොන්ගාරාගි බෙයිදා", "To cut one's finger", "අනතුරු", 48, 2),
                Vocabulary("v48_4", "손가락이 끼이다", "ඇඟිල්ල හිරවෙනවා (යන්ත්‍රයකට)", "සොන්ගාරාගි කිඉදා", "To get finger caught in machine", "අනතුරු", 48, 2),
                Vocabulary("v48_5", "추락하다 / 떨어지다", "ඉහළ සිට පහළට වැටෙනවා", "චුරාක්හාදා / තොරෝජිදා", "To fall from a height", "අනතුරු", 48, 2),
                Vocabulary("v48_6", "미끄러지다", "ලිස්සා වැටෙනවා", "මිකුරෝජිදා", "To slip", "අනතුරු", 48, 2),
                Vocabulary("v48_7", "비상벨", "හදිසි අනතුරු ඇඟවීමේ සීනුව", "බිසංබෙල්", "Emergency bell", "ආරක්ෂාව", 48, 2),
                Vocabulary("v48_8", "소화기", "ගිනි නිවන උපකරණය (Fire Extinguisher)", "සෝහ්වාගි", "Fire extinguisher", "ආරක්ෂාව", 48, 2),
                Vocabulary("v48_9", "비상구", "හදිසි පිටවීමේ දොරටුව (Emergency Exit)", "බිසංඟු", "Emergency exit", "ආරක්ෂාව", 48, 2),
                Vocabulary("v48_10", "안전수칙", "ආරක්ෂක නීති සහ පිළිවෙත්", "අන්ජොන්සුචික්", "Safety rules", "ආරක්ෂාව", 48, 2)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g48_1",
                    patternKorean = "-도록 조심하다",
                    titleSinhala = "-도록 조심하다 (... නොවීමට පරිස්සම් වන්න / Be careful so that)",
                    ruleExplanationSinhala = "යම් අනතුරක් හෝ අහිතකර සිදුවීමක් නොවීමට කල්පනාකාරී වන ලෙස උපදෙස් දීමට භාවිතා වේ.",
                    usageCondition = "ක්‍රියා ධාතුවට කෙලින්ම -도록 조심하다 එකතු වේ.",
                    examples = listOf(
                        GrammarExample("다치지 않도록 조심하세요.", "තුවාල නොවෙන්න පරිස්සම් වන්න.", "Be careful not to get hurt."),
                        GrammarExample("넘어지지 않도록 조심하세요.", "ඇද නොවැටෙන්න පරිස්සම් වන්න.", "Be careful not to trip over.")
                    )
                ),
                GrammarPoint(
                    id = "g48_2",
                    patternKorean = "-(으)ㄹ 때",
                    titleSinhala = "-(으)ㄹ 때 (... කරන විට / When doing)",
                    ruleExplanationSinhala = "යම් ක්‍රියාවක් සිදුවන අවස්ථාව හෝ මොහොත දැක්වීමට යොදා ගනී.",
                    usageCondition = "බච්චිම් ඇත්නම් -을 때, නැත්නම් -ㄹ 때 යෙදේ.",
                    examples = listOf(
                        GrammarExample("기계를 작동할 때 조심하세요.", "යන්ත්‍රය ක්‍රියාත්මක කරන විට පරිස්සම් වන්න.", "Be careful when operating machine."),
                        GrammarExample("작업할 때 안전모를 쓰세요.", "වැඩ කරන විට හෙල්මට් පළඳින්න.", "Wear safety helmet when working.")
                    )
                )
            ),
            culturalNoteSinhala = "කාර්මික අනතුරු සහ රක්ෂණය (산재보험): වැඩබිමේදී යම් අනතුරක් සිදුවුවහොත් වහාම ප්‍රධානියාට (반장님 / 사장님) දැනුම් දී රෝහල් ගත විය යුතුය. නීත්‍යානුකූල EPS සේවකයින්ට කාර්මික අනතුරු වන්දි රක්ෂණය (산재보험) මගින් සම්පූර්ණ ප්‍රතිකාර වියදම් සහ නිවාඩු කාලයේ වැටුප් හිමිවේ."
        ),
        Lesson(
            id = 49,
            bookId = 2,
            koreanTitle = "제49과 안전화를 안 신으면 다칠 수 있어요",
            sinhalaTitle = "පාඩම 49: ආරක්ෂිත සපත්තු නොදැම්මොත් අනතුරක් වෙන්න පුලුවන්",
            englishTitle = "Lesson 49: You may get injured if you don't wear safety shoes",
            topicSinhala = "ආරක්ෂිත උපකරණ සහ පැළඳීම (Protective Equipment - PPE)",
            dialogues = listOf(
                Dialogue(
                    id = "d49_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "ආරක්ෂිත හිස්වැසුම පැළඳීම",
                    contextNoteSinhala = "ඉදිකිරීම් සහ නිෂ්පාදන වැඩබිමක ආරක්ෂාව",
                    lines = listOf(
                        DialogueLine(1, "반장님 (Foreman)", "아디 씨, 안전모를 왜 안 썼어요?", "ආදි මහතා, ඇයි ආරක්ෂක හෙල්මට් එක නොදැම්මේ?", "ආදි ෂි, අන්ජොන්මෝරොල් වේ අන් සොස්සොයෝ?"),
                        DialogueLine(2, "아디 (Adhi)", "너무 더워서 잠깐 벗었어요.", "ගොඩක් රස්න නිසා ටිකකට ගැලෙව්වා.", "නොමු තොවොසෝ චම්කන් බොසොස්සොයෝ."),
                        DialogueLine(3, "반장님 (Foreman)", "위에서 물건이 떨어지면 위험해요. 어서 쓰세요.", "උඩින් බඩු වැටුණොත් අනතුරුදායකයි. ඉක්මනින් පළඳින්න.", "වී-එසෝ මුල්ගොනි තොරෝජිමියොන් විහොම්හෙයෝ. ඔසෝ සුසෙයෝ."),
                        DialogueLine(4, "아디 (Adhi)", "네, 알겠습니다. 바로 쓸게요.", "එහෙමයි, තේරුම් ගත්තා. දැන්ම පළඳින්නම්.", "නේ, අල්ගෙත්සුම්නිදා. බාරෝ සුල්ගෙයෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v49_1", "안전모", "ආරක්ෂක හිස්වැසුම (Safety Helmet)", "අන්ජොන්මෝ", "Safety helmet", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_2", "안전화", "ආරක්ෂිත සපත්තු (Safety Shoes)", "අන්ජොන්හ්වා", "Safety shoes", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_3", "안전장갑", "ආරක්ෂිත අත්වැසුම් (Safety Gloves)", "අන්ජොන්ජංගප්", "Safety gloves", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_4", "보안경", "ආරක්ෂිත ඇස් කණ්ණාඩි (Safety Goggles)", "බෝඅන්ග්යොං", "Safety goggles", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_5", "보안면", "මුහුණු ආවරණ පලිහ (Face Shield)", "බෝඅන්ම්යොන්", "Face shield", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_6", "귀마개", "කන් ආවරණ (Earplugs)", "ග්විමගේ", "Earplugs", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_7", "마스크", "මුඛ ආවරණය (Dust Mask)", "මාසුකු", "Dust mask", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_8", "안전대", "ආරක්ෂක පටිය (Safety Harness)", "අන්ජොන්දේ", "Safety harness", "ආරක්ෂක උපකරණ", 49, 2),
                Vocabulary("v49_9", "착용하다", "පළඳිනවා (Wear PPE)", "චාග්යොංහාදා", "To put on / wear", "ක්‍රියාපද", 49, 2),
                Vocabulary("v49_10", "벗다", "ගලවනවා (Take off)", "බොත්තා", "To take off", "ක්‍රියාපද", 49, 2)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g49_1",
                    patternKorean = "-(으)면",
                    titleSinhala = "-(으)면 (... නම් / If / When)",
                    ruleExplanationSinhala = "යම් කොන්දේසියක් හෝ උපකල්පනයක් ඉදිරිපත් කිරීමට යොදා ගනී.",
                    usageCondition = "බච්චිම් ඇත්නම් -으면, නැත්නම් -면 යෙදේ.",
                    examples = listOf(
                        GrammarExample("안전화를 안 신으면 다칠 수 있어요.", "ආරක්ෂිත සපත්තු නොදැම්මොත් තුවාල වෙන්න පුලුවන්.", "You can get injured if you don't wear safety boots."),
                        GrammarExample("시간이 있으면 영화를 봐요.", "වේලාව තිබේ නම් චිත්‍රපටයක් බලනවා.", "If I have time, I watch a movie.")
                    )
                ),
                GrammarPoint(
                    id = "g49_2",
                    patternKorean = "-(으)ㄹ 수 있다/없다",
                    titleSinhala = "-(으)ㄹ 수 있다/없다 (... කළ හැකියි / නොහැකියි - Can / Cannot)",
                    ruleExplanationSinhala = "හැකියාව හෝ හැකියාවක් නොමැතිකම ප්‍රකාශ කිරීමට යොදා ගනී.",
                    usageCondition = "බච්චිම් ඇත්නම් -을 수 있다/없다, නැත්නම් -ㄹ 수 있다/없다 යෙදේ.",
                    examples = listOf(
                        GrammarExample("한국어를 할 수 있어요.", "කොරියන් කතා කරන්න පුලුවන්.", "I can speak Korean."),
                        GrammarExample("지금은 갈 수 없어요.", "දැන් යන්න බැහැ.", "I cannot go now.")
                    )
                )
            ),
            culturalNoteSinhala = "ආරක්ෂක උපකරණ පැළඳීමේ වැදගත්කම (보호구 착용의 중요성): කොරියානු කම්කරු නීතියට අනුව ආරක්ෂිත උපකරණ නොපැළඳ වැඩ කිරීම නීතිවිරෝධී වන අතර, එමගින් සිදුවන අනතුරු සඳහා වන්දි මුදල් අඩුවීමටද ඉඩ ඇත. එබැවින් වැඩබිමට පිවිසෙන විට නියමිත ආරක්ෂිත උපකරණ පැළඳීම අනිවාර්ය වේ."
        ),
        Lesson(
            id = 52,
            bookId = 2,
            koreanTitle = "제52과 근로 조건이 좋은 편이에요",
            sinhalaTitle = "පාඩම 52: සේවා කොන්දේසි හොඳ මට්ටමක තියෙනවා",
            englishTitle = "Lesson 52: The working conditions are pretty good",
            topicSinhala = "සේවා කොන්ත්‍රාත්තුව, සේවා කාලය සහ වැටුප් (Labor Contract, Hours & Salary)",
            dialogues = listOf(
                Dialogue(
                    id = "d52_1",
                    titleKorean = "대화 1 (සංවාදය 1)",
                    titleSinhala = "සේවා කොන්ත්‍රාත්තුව කියවා බැලීම",
                    contextNoteSinhala = "කොරියාවට පැමිණීමට පෙර අත්සන් කරන ප්‍රමිතිගත සේවා ගිවිසුම",
                    lines = listOf(
                        DialogueLine(1, "투안 (Tuan)", "이 계약서가 표준근로계약서예요?", "මේ කොන්ත්‍රාත්තුව ප්‍රමිතිගත සේවා ගිවිසුමද?", "ඉ ක්යේයාක්සෝගා ප්යෝජුන් කුන්රෝ ක්යේයාක්සෝයෙයෝ?"),
                        DialogueLine(2, "상담사 (Counselor)", "네, 맞아요. 근무 시간과 휴일, 급여가 적혀 있어요.", "ඔව්, හරි. වැඩ කරන වේලාවන්, නිවාඩු සහ වැටුප ලියා තියෙනවා.", "නේ, මාජායෝ. කුන්මු ශිගාන්-ග්වා හ්යුයිල්, කුබ්යෝගා චොක්හ්යෝ ඉස්සොයෝ."),
                        DialogueLine(3, "투안 (Tuan)", "하루에 몇 시간 일해요?", "දවසකට පැය කීයක් වැඩ කරනවද?", "හාරුයේ ම්යොත් ශිගාන් ඉල්හෙයෝ?"),
                        DialogueLine(4, "상담사 (Counselor)", "하루 8시간, 주 40시간이 기본이에요. 연장근로는 수당을 받아요.", "දිනකට පැය 8යි, සතියකට පැය 40යි මූලික කාලය. අතිකාල වැඩට (OT) දීමනා ලැබෙනවා.", "හාරු යොදොල් ශිගාන්, චු සාශිප් ශිගානි කිබොනියෙයෝ. යොන්ජංගුන්රෝනින් සුදංගොල් බාදායෝ.")
                    )
                )
            ),
            vocabularies = listOf(
                Vocabulary("v52_1", "표준근로계약서", "ප්‍රමිතිගත සේවා ගිවිසුම (Standard Labor Contract)", "ප්යෝජුන් කුන්රෝ ක්යේයාක්සෝ", "Standard Labor Contract", "නීතිය", 52, 2),
                Vocabulary("v52_2", "근로 계약 기간", "සේවා ගිවිසුම් කාලසීමාව", "කුන්රෝ ක්යේයාක් කිගාන්", "Contract period", "නීතිය", 52, 2),
                Vocabulary("v52_3", "수습 기간", "පරිවාස කාලය (Probation Period)", "සුසුප් කිගාන්", "Probation period", "නීතිය", 52, 2),
                Vocabulary("v52_4", "근무 시간", "වැඩ කරන කාලය (Working Hours)", "කුන්මු ශිගාන්", "Working hours", "කොන්දේසි", 52, 2),
                Vocabulary("v52_5", "휴게 시간", "විවේක කාලය (Break Time)", "හ්යුගේ ශිගාන්", "Break time", "කොන්දේසි", 52, 2),
                Vocabulary("v52_6", "휴일", "නිවාඩු දිනය (Day off / Holiday)", "හ්යුයිල්", "Holiday / Day off", "කොන්දේසි", 52, 2),
                Vocabulary("v52_7", "기본급", "මූලික වැටුප (Basic Salary)", "කිබොන්ගුප්", "Basic pay", "වැටුප්", 52, 2),
                Vocabulary("v52_8", "연장근로수당", "අතිකාල දීමනාව (Overtime Pay - OT)", "යොන්ජංගුන්රෝ සුදං", "Overtime allowance", "වැටුප්", 52, 2),
                Vocabulary("v52_9", "숙식 제공", "නවාතැන් සහ ආහාර සැපයීම", "සුක්ෂික් චේගොං", "Board and lodging provided", "පහසුකම්", 52, 2),
                Vocabulary("v52_10", "식대", "ආහාර වියදම", "ශික්දේ", "Meal expenses", "පහසුකම්", 52, 2)
            ),
            grammars = listOf(
                GrammarPoint(
                    id = "g52_1",
                    patternKorean = "-기 전에",
                    titleSinhala = "-기 전에 (... කිරීමට පෙර / Before doing)",
                    ruleExplanationSinhala = "යම් ක්‍රියාවක් කිරීමට පෙරාතුව සිදු කළ යුතු දෙයක් ප්‍රකාශ කිරීමට යොදා ගනී.",
                    usageCondition = "ක්‍රියා ධාතුවට කෙලින්ම -기 전에 එකතු වේ.",
                    examples = listOf(
                        GrammarExample("계약하기 전에 조건을 확인하세요.", "ගිවිසුම අත්සන් කිරීමට පෙර කොන්දේසි පරීක්ෂා කරන්න.", "Check conditions before signing."),
                        GrammarExample("밥을 먹기 전에 손을 씻어요.", "කෑම කෑමට පෙර අත් සෝදන්න.", "Wash hands before eating.")
                    )
                ),
                GrammarPoint(
                    id = "g52_2",
                    patternKorean = "-(으)ㄴ 편이다",
                    titleSinhala = "-(으)ㄴ 편이다 (යම් තරමකට ... පැත්තට බරයි / On the ... side)",
                    ruleExplanationSinhala = "දෙයක් නිශ්චිතවම නිරපේක්ෂ නොවුවත්, සාමාන්‍යයෙන් එම ගණයට අයත් වන බව පැවසීමට යොදා ගනී.",
                    usageCondition = "විශේෂණ පදයට බච්චිම් ඇත්නම් -은 편이다, නැත්නම් -ㄴ 편이다 යෙදේ.",
                    examples = listOf(
                        GrammarExample("근로 조건이 좋은 편이에요.", "සේවා කොන්දේසි හොඳ පැත්තක තියෙනවා.", "Conditions are fairly good."),
                        GrammarExample("월급이 많은 편이에요.", "වැටුප වැඩි පැත්තක තියෙනවා.", "Salary is relatively high.")
                    )
                )
            ),
            culturalNoteSinhala = "EPS සේවා කොන්ත්‍රාත්තුව අත්සන් කිරීම (근로계약 체결): කොරියාවේ EPS ක්‍රමය යටතේ සේවා ගිවිසුම් කාලය සාමාන්‍යයෙන් වසර 3ක් වන අතර, පසුව වසර 1ක් සහ මාස 10ක් දීර්ඝ කර ගත හැකිය (මුළු කාලය වසර 4යි මාස 10යි). සේවා ගිවිසුමේ අඩංගු මූලික වැටුප, නවාතැන් ගාස්තු සහ වැඩ කරන වේලාවන් පැහැදිලිව තහවුරු කරගත යුතුය."
        )
    )
}
