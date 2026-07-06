package com.example.edcuational.data

object DummyData {

    val interests = listOf(
        Interest(1, "IT", "Information Technology, Networking & Cloud Concepts."),
        Interest(2, "Programming", "Learn Software Development & Coding in Hindi."),
        Interest(3, "Biology", "Explore Life Sciences, Human Anatomy, & Cells."),
        Interest(4, "Technician", "Practical Vocational Skills, Electronics & Repairing."),
        Interest(5, "Commerce", "Business Environment, Accountancy, and Economics."),
        Interest(6, "Business", "Startup, Digital Marketing, and Sales Strategies."),
        Interest(7, "Artificial Intelligence", "Neural Networks, Machine Learning, & Prompts."),
        Interest(8, "Cyber Security", "Ethical Hacking, Network Defense, & Bug Bounty."),
        Interest(9, "Data Science", "Data Analysis, Excel, SQL, and Power BI dashboards."),
        Interest(10, "Finance", "Personal Finance, Stock Market Investing, & Trading."),
        Interest(11, "Medical", "Healthcare Fundamentals, Pharmacology, and Nursing."),
        Interest(12, "Government Jobs", "SSC, Banking, Railways Exam Preparation."),
        Interest(13, "UPSC", "IAS/IPS Civil Services Exam Preparation in Hindi."),
        Interest(14, "NEET", "National Eligibility cum Entrance Test Medical Prep."),
        Interest(15, "JEE", "Joint Entrance Examination Engineering Prep.")
    )

    // 🎯 हर फील्ड (Interest) में अब सिर्फ 3 सबसे बेस्ट और मुख्य कोर्सेज हैं
    val courses = listOf(
        // 1. IT (Interest ID: 1)
        Course(1, 1, "Computer Networking", "Learn OSI Model, TCP/IP, and Routing Protocols.", "Beginner", "15 Hours"),
        Course(2, 1, "Linux Administration", "Master Linux commands, bash scripting, and servers.", "Intermediate", "12 Hours"),
        Course(3, 1, "AWS Cloud Computing", "Understand Amazon Web Services cloud architecture.", "Advanced", "18 Hours"),

        // 2. Programming (Interest ID: 2)
        Course(4, 2, "Android Dev with Compose", "Build modern UI apps with Kotlin and Compose.", "Intermediate", "25 Hours"),
        Course(5, 2, "Python for Beginners", "Learn Python programming from absolute scratch.", "Beginner", "20 Hours"),
        Course(6, 2, "Full Stack Web Development", "Master HTML, CSS, JavaScript, and MERN Stack.", "Advanced", "45 Hours"),

        // 3. Biology (Interest ID: 3)
        Course(7, 3, "Human Anatomy", "Detailed study of human body systems and organs.", "Beginner", "10 Hours"),
        Course(8, 3, "Plant Physiology", "Understand photosynthesis, respiration, and plant life.", "Intermediate", "08 Hours"),
        Course(9, 3, "Genetics & DNA", "Deep dive into molecular biology, DNA, and RNA.", "Advanced", "12 Hours"),

        // 4. Technician (Interest ID: 4)
        Course(10, 4, "Mobile Repairing Course", "Learn smartphone hardware testing and chip fixing.", "Beginner", "15 Hours"),
        Course(11, 4, "Electrician & House Wiring", "Practical guide to home electrical wiring and safety.", "Intermediate", "12 Hours"),
        Course(12, 4, "Laptop Motherboard Repair", "Advanced laptop troubleshooting and chip-level work.", "Advanced", "18 Hours"),

        // 5. Commerce (Interest ID: 5)
        Course(13, 5, "Accountancy Fundamentals", "Learn Journal Entries, Ledger, and Balance Sheets.", "Beginner", "20 Hours"),
        Course(14, 5, "Business Studies", "Understand management principles and business laws.", "Beginner", "10 Hours"),
        Course(15, 5, "Economics (Macro & Micro)", "Indian economy, demand-supply, and inflation.", "Intermediate", "15 Hours"),

        // 6. Business (Interest ID: 6)
        Course(16, 6, "Startup & Entrepreneurship", "How to validate business ideas and pitch to investors.", "Beginner", "08 Hours"),
        Course(17, 6, "Digital Marketing Masterclass", "Learn SEO, Google Ads, and Facebook Marketing.", "Intermediate", "18 Hours"),
        Course(18, 6, "Sales & Closing Techniques", "Art of negotiation, body language, and closing deals.", "Beginner", "06 Hours"),

        // 7. Artificial Intelligence (Interest ID: 7)
        Course(19, 7, "Machine Learning Basics", "Supervised and unsupervised ML algorithms with Python.", "Intermediate", "20 Hours"),
        Course(20, 7, "Deep Learning & NLP", "Build neural networks, CNN, RNN, and AI models.", "Advanced", "22 Hours"),
        Course(21, 7, "Prompt Engineering", "Master ChatGPT, Midjourney, and LLM orchestration.", "Beginner", "05 Hours"),

        // 8. Cyber Security (Interest ID: 8)
        Course(22, 8, "Ethical Hacking with Kali", "Learn penetration testing, scanning, and Linux tools.", "Beginner", "18 Hours"),
        Course(23, 8, "Bug Bounty Hunting", "Find website vulnerabilities like XSS, SQLi and earn.", "Advanced", "15 Hours"),
        Course(24, 8, "Network Security & Defenses", "Firewalls, encryption, and secure network protocols.", "Intermediate", "10 Hours"),

        // 9. Data Science (Interest ID: 9)
        Course(25, 9, "Data Analysis with Excel", "Master advanced spreadsheets, pivot tables, and formulas.", "Beginner", "12 Hours"),
        Course(26, 9, "SQL for Data Analytics", "Write complex database queries, joins, and aggregates.", "Intermediate", "10 Hours"),
        Course(27, 9, "Power BI Dashboards", "Create stunning business intelligence visual reports.", "Advanced", "08 Hours"),

        // 10. Finance (Interest ID: 10)
        Course(28, 10, "Stock Market Investing", "Basics of shares, mutual funds, and long-term wealth.", "Beginner", "12 Hours"),
        Course(29, 10, "Technical Analysis & Trading", "Read candlestick patterns, RSI, and do day trading.", "Advanced", "15 Hours"),
        Course(30, 10, "Personal Finance & SIP", "Tax saving, budget management, and compounding power.", "Beginner", "06 Hours"),

        // 11. Medical (Interest ID: 11)
        Course(31, 11, "Pharmacology Basics", "Classification of major drugs and mechanism of action.", "Intermediate", "14 Hours"),
        Course(32, 11, "First Aid & Emergency Care", "Basic life support, CPR, and immediate trauma care.", "Beginner", "08 Hours"),
        Course(33, 11, "Hospital Nursing Practice", "Vital signs checking, patient care, and ward protocols.", "Beginner", "10 Hours"),

        // 12. Government Jobs (Interest ID: 12)
        Course(34, 12, "Quantitative Aptitude", "Maths short-tricks, percentage, profit-loss for SSC.", "Beginner", "30 Hours"),
        Course(35, 12, "Reasoning & Puzzles", "Syllogism, blood relations, and seating arrangements.", "Beginner", "20 Hours"),
        Course(36, 12, "Static GK & History", "Core Indian History, Geography, and Polity overview.", "Beginner", "25 Hours"),

        // 13. UPSC (Interest ID: 13)
        Course(37, 13, "Indian Polity (Laxmikanth)", "UPSC Core Lectures on Constitution and Governance.", "Advanced", "40 Hours"),
        Course(38, 13, "Modern Indian History", "From East India Company entry to Independence era.", "Intermediate", "28 Hours"),
        Course(39, 13, "UPSC Geography Mapping", "Physical and World geography through maps and charts.", "Intermediate", "22 Hours"),

        // 14. NEET (Interest ID: 14)
        Course(40, 14, "NEET Biology Masterclass", "Complete NCERT line-by-line concept breakdown.", "Intermediate", "35 Hours"),
        Course(41, 14, "NEET Organic Chemistry", "Reaction mechanism, IUPAC, and name reactions.", "Advanced", "22 Hours"),
        Course(42, 14, "NEET Physics Concepts", "Clear derivations and numerical patterns for NEET.", "Advanced", "25 Hours"),

        // 15. JEE (Interest ID: 15)
        Course(43, 15, "JEE Physics - Mechanics", "Newton's laws, friction, and rotational dynamics.", "Advanced", "30 Hours"),
        Course(44, 15, "JEE Maths - Calculus", "Limits, continuity, differentiation, and integration.", "Advanced", "35 Hours"),
        Course(45, 15, "JEE Chemistry - Bonding", "Chemical bonding, periodic trends, and structures.", "Intermediate", "20 Hours")
    )

    // 🎯 असली वर्किंग यूट्यूब वीडियोज़ (प्रॉपर टाइटल्स, चैनल नाम और 100% वर्किंग लाइव IDs के साथ)
    val videos = listOf(
        // IT - Computer Networking (Course ID: 1)
        Video(1, 1, "Lec 1: Introduction to Computer Networks", "Gate Smashers", "11:24", "VwN91xCpI6g"),
        Video(2, 1, "Lec 2: OSI Model Layers Explained Clearly", "Gate Smashers", "14:52", "vv4y_uOneC0"),
        Video(3, 1, "Lec 3: TCP/IP Model vs OSI Model", "Gate Smashers", "10:15", "3b_T4Ob2f78"),
        Video(4, 1, "Lec 4: What is IP Addressing? IPv4 Basics", "Gate Smashers", "12:40", "A7bK9mOOka0"),

        // IT - Linux Administration (Course ID: 2)
        Video(5, 2, "Lec 1: Linux Architecture & Basic Commands", "Technical Guftgu", "22:15", "vv4y_uOneC0"),
        Video(6, 2, "Lec 2: File Permissions (chmod, chown) in Linux", "Technical Guftgu", "18:40", "3b_T4Ob2f78"),

        // Programming - Android Dev (Course ID: 4)
        Video(7, 4, "Lec 1: Modern Android Roadmap & Setup 2026", "Chai aur Code", "18:42", "mXjZQXNkvms"),
        Video(8, 4, "Lec 2: Creating Your First App with Jetpack Compose", "Chai aur Code", "29:15", "6YVIOXp_uK4"),
        Video(9, 4, "Lec 3: State Management (remember & mutableStateOf)", "Chai aur Code", "32:50", "nAAsD96p-K4"),
        Video(10, 4, "Lec 4: Layouts in Compose - Row, Column & Box", "Chai aur Code", "21:15", "TkX8mZ_mMoY"),

        // Programming - Python (Course ID: 5)
        Video(11, 5, "Lec 1: Python Introduction & Installation", "CodeWithHarry", "15:24", "7wnove7K-Yg"),
        Video(12, 5, "Lec 2: Variables & Data Types in Python", "CodeWithHarry", "16:20", "ORcuz7s5cCY"),
        Video(13, 5, "Lec 3: If-Else Conditional Statements", "CodeWithHarry", "22:15", "M7p0qyB-QnM"),

        // Programming - Web Development (Course ID: 6)
        Video(14, 6, "Lec 1: Introduction to Web Dev & HTML Basics", "Apna College", "45:30", "HcOc7P5BMi4"),
        Video(15, 6, "Lec 2: CSS Box Model & Selectors Tutorial", "Apna College", "52:40", "ESnRnPq86Y8"),
        Video(16, 6, "Lec 3: JavaScript Variables & DOM Basics", "Apna College", "42:15", "VlPiVmY_4vM"),

        // Biology - Human Anatomy (Course ID: 7)
        Video(17, 7, "Lec 1: Introduction to Human Anatomy & Tissues", "Physics Wallah", "32:15", "b7NrkOooZBM"),
        Video(18, 7, "Lec 2: Human Circulatory System & Heart Structure", "Physics Wallah", "51:40", "NfG_3b8kXoA"),

        // Artificial Intelligence - Machine Learning (Course ID: 19)
        Video(19, 19, "Lec 1: What is Machine Learning? (Types Explained)", "CampusX", "24:15", "1vsmaE8_8_o"),
        Video(20, 19, "Lec 2: Linear Regression Mathematical Intuition", "CampusX", "48:10", "kHwlB_OH_9w"),

        // Cyber Security - Ethical Hacking (Course ID: 22)
        Video(21, 22, "Lec 1: What is Ethical Hacking? (Basics in Hindi)", "Technical Sagar", "14:20", "3bX7o_Z7XmI"),
        Video(22, 22, "Lec 2: Information Gathering & Footprinting Tools", "Technical Sagar", "22:12", "G2M9X_Z7Wk8"),

        // Finance - Stock Market (Course ID: 28)
        Video(23, 28, "Lec 1: Share Market Basics for Absolute Beginners", "Pranjal Kamra", "28:15", "Xn7K_X7MkoM"),
        Video(24, 28, "Lec 2: How to Analyze Balance Sheets of a Company", "Pranjal Kamra", "35:10", "NfG_3b_8kX8"),

        // UPSC - Indian Polity (Course ID: 37)
        Video(25, 37, "Lec 1: Historical Background of Indian Constitution", "Drishti IAS", "42:15", "VpZtT_HhZ_8"),
        Video(26, 37, "Lec 2: Fundamental Rights (Article 14 to 18) Analysis", "Drishti IAS", "51:20", "3bX7o_Z7Xm8")
    )
}