package sarveshchavan777.inrerface2.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import sarveshchavan777.inrerface2.Activity.FreeHint;
import sarveshchavan777.inrerface2.Activity.Questions;

public class DemoHelperClass extends SQLiteOpenHelper {
    Context context;

    private static final String DATABASE_NAME = "DEMOGAMEDBB";
   //If any modifications in the table or db just increment this no
    private static int DATABASE_VERSION = 1035;
    //Table one
    private static final String TABLE_NAME = "TRIVIAQUIZ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String ANSWER = "ANSWER";
    private static final String ANSWER2 = "ANSWER2";
    private static final String RANDOMANS1 = "RANDOMANS1";
    private static final String RANDOMANS2 = "RANDOMANS2";
    private static final String USELESSSTRING = "USELESSSTRING";
    //first - que , sec -correct ans part1 , third - correct ans part2 , fourth - the letters below boxes row 1 , fifth - the letters below boxes row 2  ,sixth - the useless char in below boxes which is not the part of ans
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + ANSWER + " VARCHAR(255), " + ANSWER2 + " VARCHAR(255), " + RANDOMANS1 + " VARCHAR(255), " + RANDOMANS2 + " VARCHAR(255), " + USELESSSTRING + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    //Table two
    private static String TABLE_NAME2 = "TRIVIAQUIZ2";
    private static final String CORRECTNO = "CORRECTNO";
    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ( " + CORRECTNO + " INTEGER );";
    private static final String DROP_TABLE2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;
    //Table three
    private static String TABLE_NAME3 = "TRIVIAQUIZ3";
    private static final String HINTID = "HINTID";
    private static final String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME3 + " ( " + HINTID + " INTEGER );";
    private static final String DROP_TABLE3 = "DROP TABLE IF EXISTS " + TABLE_NAME3;
    //Table four
    private static String TABLE_NAME4 = "TRIVIAQUIZ4";
    private static final String ID= "ID";
    private static final String ONE= "ONE";
    private static final String TWO = "TWO";
    private static final String THREE = "THREE";
    private static final String FOUR = "FOUR";
    private static final String FIVE = "FIVE";
    private static final String CREATE_TABLE4 = "CREATE TABLE " + TABLE_NAME4 + " ( " + ID + " INTEGER , " + ONE + " INTEGER , " + TWO + " INTEGER , " + THREE + " INTEGER , " + FOUR + " INTEGER , " + FIVE + " INTEGER);";
    private static final String DROP_TABLE4 = "DROP TABLE IF EXISTS " + TABLE_NAME4;
    //Table five
    private static String TABLE_NAME8 = "TRIVIAQUIZ8";
    private static final String GEMS = "GEMS";
    private static final String CREATE_TABLE8 = "CREATE TABLE " + TABLE_NAME8 + " ( " + GEMS + " INTEGER );";
    private static final String DROP_TABLE8 = "DROP TABLE IF EXISTS " + TABLE_NAME8;
    //Table six
    private static String TABLE_NAME11 = "TRIVIAQUIZ11";
    private static final String storePauseValue = "storePauseValue";
    private static final String CREATE_TABLE11 = "CREATE TABLE " + TABLE_NAME11 + " ( " + storePauseValue + " INTEGER );";
    private static final String DROP_TABLE11 = "DROP TABLE IF EXISTS " + TABLE_NAME11;
    //Table seven
    private static String TABLE_NAME12 = "TRIVIAQUIZ12";
    private static final String BOOM = "BOOM";
    private static final String CREATE_TABLE12 = "CREATE TABLE " + TABLE_NAME12 + " ( " + BOOM + " INTEGER );";
    private static final String DROP_TABLE12 = "DROP TABLE IF EXISTS " + TABLE_NAME12;
    //Table eight
    private static String TABLE_NAME13 = "TRIVIAQUIZ13";
    private static final String SOUND = "SOUND";
    private static final String CREATE_TABLE13 = "CREATE TABLE " + TABLE_NAME13 + " ( " + SOUND + " INTEGER );";
    private static final String DROP_TABLE13 = "DROP TABLE IF EXISTS " + TABLE_NAME13;
    //Table nine
    private static String TABLE_NAME14 = "TRIVIAQUIZ14";
    private static final String CHEKQADDED = "CHEKQADDED";
    private static final String CREATE_TABLE14 = "CREATE TABLE " + TABLE_NAME14 + " ( " + CHEKQADDED + " INTEGER );";
    private static final String DROP_TABLE14 = "DROP TABLE IF EXISTS " + TABLE_NAME14;


    public DemoHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        sqLiteDatabase.execSQL(CREATE_TABLE3);
        sqLiteDatabase.execSQL(CREATE_TABLE4);
        //sqLiteDatabase.execSQL(CREATE_TABLE5);
        //sqLiteDatabase.execSQL(CREATE_TABLE6);

        sqLiteDatabase.execSQL(CREATE_TABLE8);
        //sqLiteDatabase.execSQL(CREATE_TABLE9);
        //sqLiteDatabase.execSQL(CREATE_TABLE10);
        sqLiteDatabase.execSQL(CREATE_TABLE11);
        sqLiteDatabase.execSQL(CREATE_TABLE12);
        sqLiteDatabase.execSQL(CREATE_TABLE13);
        sqLiteDatabase.execSQL(CREATE_TABLE14);
        // Toast.makeText(context,"oncreate called",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // i=oldVersion i1=new newVersion
      /*  sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_TABLE14);

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE14);*/

        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_TABLE2);
        sqLiteDatabase.execSQL(DROP_TABLE3);
        sqLiteDatabase.execSQL(DROP_TABLE4);
        //sqLiteDatabase.execSQL(DROP_TABLE5);
        //sqLiteDatabase.execSQL(DROP_TABLE6);

        sqLiteDatabase.execSQL(DROP_TABLE8);
        //sqLiteDatabase.execSQL(DROP_TABLE9);
        //sqLiteDatabase.execSQL(DROP_TABLE10);
        sqLiteDatabase.execSQL(DROP_TABLE11);
        sqLiteDatabase.execSQL(DROP_TABLE12);
        sqLiteDatabase.execSQL(DROP_TABLE13);
        sqLiteDatabase.execSQL(DROP_TABLE14);
        // Toast.makeText(context,String.valueOf(i+" "+i1),Toast.LENGTH_LONG).show();
        onCreate(sqLiteDatabase);
    }

    public void addquestions() {
        ArrayList<Questions> allQuestions = new ArrayList<>();
        //first - que , sec -correct ans part1 , third - correct ans part2 , fourth - the letters below boxes row 1 , fifth - the letters below boxes row 2  ,sixth - the useless char in below boxes which is not the part of ans
        allQuestions.add(new Questions("Who was the first African American to have served as president of United States of America ?", "BarACk", "ObaMA", "BARIACKTE", "OBMAMAPSF", "ITEMPSF"));

        allQuestions.add(new Questions("Who co-founded Apple company with Steve Wozniak & Ronald Wayne ?", "STEVE", "JOBS", "OAEESVSC", "AWOBFOTJ", "COAOFWA"));

        allQuestions.add(new Questions("Who was the first elected President of South Africa ?", "NELSON", "MANDELA", "PNDAYLELS", "ONNEWMCCA", "CCYPW"));

        allQuestions.add(new Questions("Which German born physicist developed the Special theory of relativity which has the famous equation E = mc^2 ?", "ALBERT", "EINSTEIN", "ISTENIRTN", "LERKELCBA", "LRKC"));

        allQuestions.add(new Questions("Disneyland theme park located in US is the brainchild of which creative genius ?", "WALT", "DISNEY", "ERISWYLA", "DYTNLLVG", "RVLGLY"));

        allQuestions.add(new Questions("Who is know as the 'King of Pop' ?", "MICHAEL", "JACKSON", "MHJSCANCI", "NDEDALKKO", "KNDD"));

        allQuestions.add(new Questions("The war drama film ‘Born on the Fourth of July’ (1989) is one of best known movie of which actor ?", "TOM", "CRUISE", "KCIUYMJR", "SWGCETUO", "KGWJYUC"));

        allQuestions.add(new Questions("Which cricketer is also know as 'God of Cricket'?", "SACHIN", "TENDULKAR", "KDCINLRTE", "HGATUHSAN", "GTH"));

        allQuestions.add(new Questions("Who was the first man ever to walk on the surface of the Moon ?", "NEIL", "ARMSTRONG", "MTOLCRGNX", "CNREAPSIL", "PCLXC"));

        allQuestions.add(new Questions("In 2015, who has been estimated to have a net worth of 1 billion dollars, setting the record of being the first billionaire athlete(Basketball player) ever ?", "MICHAEL", "JORDAN", "RNLIHAEMV", "JDWJCOBCA", "VWJBC"));

        allQuestions.add(new Questions("Who co-founded Microsoft company with Paul Allen, which became the world's largest PC software company ?", "BILL", "GATES", "SLELIILS", "TWSAOBPG", "PWSILOS"));

        allQuestions.add(new Questions("At the 2008 Beijing olympics, which athlete won gold medals in 100m, 200m and 4x100m relay ?", "USAIN", "BOLT", "NQODOLIV", "AWPSTTBU", "VTODQWP"));

        allQuestions.add(new Questions("In 2011 ‘The Karate Kid’ was remade starring  ______ & Jaden Smith in it. The movie was a big success at the box office, earning over 358 million US dollars.", "JACKIE", "CHAN", "RRHREIAA", "KCNZJAGC", "ZGRRAR"));

        allQuestions.add(new Questions("\"_____ Schwarzenegger\"(surname) is an American actor popularly known as \"Terminator\" and was also the former Governor of California ?", "ARNOLD", "", "UDTOLRW", "DNARVSO", "SWOUDTVR"));

        allQuestions.add(new Questions("Who co-founded the social-networking website Facebook out of his college dorm room ?", "MARK", "ZUCKERBERG", "KDBERRUCK", "EKGARZAOM", "OKAD"));

        allQuestions.add(new Questions("Who founded the Missionaries of Charity in Calcutta(INDIA) with the objective of serving the poorest of the poor ?", "MOTHER", "TERESA", "IEWPWRTHR", "ESOTHEAMT", "ITWWHP"));

        allQuestions.add(new Questions("She was posthumously honoured with the Congressional Space Medal of Honor, NASA Space Flight Medal and NASA Distinguished Service Medal. She was Indian American astronaut who died in the Space Shuttle Columbia disaster(2003),Guess her name.", "KALPANA", "CHAWLA", "DWHTACALN", "PALOKAAPC", "CODTP"));

        allQuestions.add(new Questions("Which famous chef revealed one of the secrets to his success thus, “If you want to become a great chef, you have to work with great chefs. And that's exactly what I did”.", "GORDON", "RAMSAY", "RXMNRAOQN", "SABODMGFY", "BXQNMF"));

        allQuestions.add(new Questions("Who became the first youtuber to hit 56 million subscribers ?", "PEWDIEPIE", "", "PFWEIECD", "IIDEETPC", "CTDFICE"));

        allQuestions.add(new Questions("Who was a French biologist, microbiologist and chemist renowned for his discoveries of the principles of vaccination, microbial fermentation and pasteurization ?", "LOUIS", "PASTEUR", "FQSIOBNVS", "PTUURESLA", "QFBSVN"));

        allQuestions.add(new Questions("The \"_____ brothers\", Orville and Wilbur, were two American brothers, inventors, and aviation pioneers who are generally credited with inventing, building, and flying the world's first successful airplane.", "WRIGHT", "", "THXTWFI", "RGLUVSX", "VSTFLUXX"));

        allQuestions.add(new Questions("Who is the current President of the Russian Federation ?\nHe was Prime Minister from 1999 to 2000, President from 2000 to 2008, and again Prime Minister from 2008 to 2012.", "VLADIMIR", "PUTIN", "TIXSKILPT", "LNDAIMURV", "LKSXT"));

        allQuestions.add(new Questions("Who was famous for his character \"The Tramp\" ?\n The sweet little man with a bowler hat, mustache and cane, he was an iconic figure of the silent-film era and one of film's first superstars.", "CHARLIE", "CHAPLIN", "HHLACIBNJ", "RPILVCAGE", "VBJG"));

        allQuestions.add(new Questions("Who is a Polish-American technology executive and also the current CEO of YouTube ?", "SUSAN", "WOJCICKI", "AIKSZNASC", "WCUJBUAIO", "BAAZU"));

        allQuestions.add(new Questions("Who is a famous American actor and singer, who is known for his performances in movies like ‘I am Legend’ and ‘Hancock’ ?", "WILL", "SMITH", "LGFTTHEI", "JUILMWSV", "TGEUFJV"));

        allQuestions.add(new Questions("Who is a famous Jamaican reggae singer, known for his album ‘Rastaman Vibration’ ?", "BOB", "MARLEY", "LOMWYSAE", "RQBPBEEO", "SEQWOPE"));

        allQuestions.add(new Questions("Who was the inventor of dynamite and a manufacturer of arms who left his vast fortunes to institute the Nobel Prizes ?", "ALFRED", "NOBEL", "BYNFALEHQ", "EZDDLNERO", "QZDENYH"));

        allQuestions.add(new Questions("Who is the 45th & current President of the United States ?\nHint: Before entering politics he was a businessman and television a_maingame.", "DONALD", "TRUMP", "QOMRADLAD", "UFTWCEYNP", "EQWYFCA"));

        allQuestions.add(new Questions("Who was the infamous dictator of Germany who carried out the genocide of Jews and was majorly responsible for the World War II ?", "ADOLF", "HITLER", "PLCRELANH", "FDIHFOKTE", "PCFHKNE"));

        allQuestions.add(new Questions("An computer programmer and businessman who is best known as the co-founder and president of the video game development & digital distribution company Valve Corporation ?", "GABE", "NEWELL", "TGNLLALN", "WIKGBEEE", "TIKNGL"));

        allQuestions.add(new Questions("In \"Harry Potter\" series which actor played the character of Harry Potter ?", "DANIEL", "RADCLIFFE", "AXRLCDFDI", "LEFNEADIU", "XUD"));

        allQuestions.add(new Questions("In the Disney Channel television series \"Hannah Montana\" (2006) who became a teen idol starring as the character Miley Stewart ?", "MILEY", "CYRUS", "SIZMYMPR", "CUIYBELS", "MPBIZS"));

        allQuestions.add(new Questions("Who was an American professional boxer and activist who became the first and only three-time lineal World Heavyweight Champion ?", "MUHAMMAD", "ALI", "AAMILANMN", "MZDOVSHUS", "SNVZNSO"));

        allQuestions.add(new Questions("Which inventor gave world the first practical electric light bulb ?\n He suffered from hearing impairment since young and became deaf as an adult.", "THOMAS", "EDISON", "IESTESPND", "DFMADMHOO", "MDPFED"));

        allQuestions.add(new Questions("Who was the sixteenth President of the United States & the first US President to be assassinated ?", "ABRAHAM", "LINCOLN", "BLMLCANRV", "AJRNTAOHI", "TRJV"));

        allQuestions.add(new Questions("Who was one of the most iconic martial arts instructors who also played lead role in the film \"Enter the Dragon\" (1973) ?", "BRUCE", "LEE", "CUBEHRK", "ELERMSW", "SWHKMR"));

        allQuestions.add(new Questions("Who is Known as the \"Oracle of Omaha ?\nHe is one of the most successful investors of all time.\n His Berkshire Hathaway owns more than 60 companies, including Geico, Duracell and Dairy Queen.", "WARREN", "BUFFETT", "IWEARRTEB", "FNTFEVDUD", "VDIED"));

        allQuestions.add(new Questions("\"Toxic\" is a song recorded by which American singer for her fourth studio album \"In the Zone\" (2003) ?", "BRITNEY", "SPEARS", "UIWYSEBPE", "NSAADRBRT", "DBUAW"));

        allQuestions.add(new Questions("Who was a Serbian-American inventor, electrical engineer, mechanical engineer, physicist, and futurist who is best known for his contributions to the design of the modern alternating current electricity supply system?", "NIKOLA", "TESLA", "LDELFGTSN", "KTSIBHAOA", "TFBDHSG"));

        allQuestions.add(new Questions("A.P.J. _____ _____, the 11th President of India, is also popularly known as the Missile Man", "ABDUL", "KALAM", "KALANLBJ", "CULDMLNA", "JLCNLN"));

        allQuestions.add(new Questions("Who is well-known for being a brutally honest judge on the reality television shows, ‘Pop Idol’, ‘American Idol’ and ‘The X factor’ ?", "SIMON", "COWELL", "OSNLWOCLT", "FELIPNMIN", "FILPTNN"));

        allQuestions.add(new Questions("\"_____ _____ Moretz\"(full name) is an American actress most famous for her role of Mia in the movie ‘If I Stay’.", "Chloe", "Grace", "RLCECHAO", "BEOEGYCS", "YBSOCE"));

        allQuestions.add(new Questions("\"Like a Virgin\" & \"MDNA\" are the albums of which American artist ?", "MADONNA", "", "MNCJAJA", "NVEOGND", "NVJEJGC"));

        allQuestions.add(new Questions("Who is a famous Canadian-American actor, comedian known for his exceptional performance in ‘The Truman Show’ ?", "JIM", "CARREY", "NROMYYCU", "EPMMRIJA", "MPUOMNY"));

        allQuestions.add(new Questions("It is said that the falling of an apple from a tree inspired a great scientist to discover the force behind the action which eventually led to the discovery of gravitational force, Name him.", "ISAAC", "NEWTON", "TTENNIIOY", "SCARMLWOA", "MTLIRYO"));

        allQuestions.add(new Questions("Who is one of the most important American political leaders of modern times and served as the 42nd President of the USA ?", "BILL", "CLINTON", "ROCWIANNL", "TXVLMBCIL", "VXRACWM"));

        allQuestions.add(new Questions("What is the name of the actress who played Hermione Granger in the Harry Potter series of films ?", "EMMA", "WATSON", "AAOOEAFS", "WHAMMATN", "OAFAHA"));

        allQuestions.add(new Questions("His novel, ‘The Adventures of Huckleberry Finn’, a direct sequel to ‘The Adventures of Tom Sawyer’, is commonly named among the Great American Novels, Name him.", "MARK", "TWAIN", "CNAKMIAC", "KWTFLHTR", "FTLHCKC"));

        allQuestions.add(new Questions("Who is often referred to as ‘People’s Princess’ & also known by nicknames, ‘Princess Di’, and ‘Lady of Hearts’ ?", "PRINCESS", "DIANA", "AIIPNRSJO", "HVESDCNJA", "VJOJH"));

        allQuestions.add(new Questions("\"_______ SHAKESPEARE\"(full name) is often referred to as England’s national poet and ‘Bard of Avon’.", "William", "", "EWNKLBA", "ILLPMIV", "BPVENKL"));

        allQuestions.add(new Questions("An American Founding Father who was the principal author of the Declaration of Independence, Name him.", "THOMAS", "JEFFERSON", "FTSZLRNHA", "EZOEJMFSO", "ZZL"));

        allQuestions.add(new Questions("Who co-founded search engine Google with Sergey Brin while doing Ph.D. studies at Stanford University, in California ?", "LARRY", "PAGE", "LAGDRBAI", "RIKPFTEY", "BIKTFDI"));

        allQuestions.add(new Questions("Who is known for his pro-environment inventions like the electricity powered sports car ‘Tesla Roadster’ ?", "ELON", "MUSK", "LZMLVEN", "UOHSKIH", "HVLIHZ"));

        allQuestions.add(new Questions("Who is a Business tycoon belonging to China known for his e-commerce business venture ‘Alibaba’.", "JACK", "MA", "ADBAJAC", "CKFOHME", "OEABCHDF"));

        allQuestions.add(new Questions("A mastermind was a renowned Greek mathematician, known as the ‘Father of Geometry’, Name him", "EUCLID", "", "BLZCEQC", "DUNCAII", "CNBQCZIA"));

        allQuestions.add(new Questions("As She is left handed, guns had to be custom made for this actress so that she could load them easily in the movie, ‘Lara Croft: Tomb Raider’, Name her.", "ANGELINA", "JOLIE", "JRLBKAENL", "ANEOAVGII", "RBKVA"));

        allQuestions.add(new Questions("\"_____ _____ Jr\" is famous for his role of iron man.", "ROBERT", "DOWNEY", "EORNEBYVM", "OTDBGRRWR", "RBRGVM"));

        allQuestions.add(new Questions("Greatest painters of the 20th century was twice conferred with the International Lenin Peace Prize, first in 1950 and next in 1961, Name him.", "PABLO", "PICASSO", "PXUOEIQPO", "CZBLAASOS", "UXEOQZ"));

        allQuestions.add(new Questions("Who played an important role in India’s struggle for freedom & also known as father of nation (India) ?", "MAHATMA", "GANDHI", "FGQIHGTAA", "AABMIHNMD", "IBFQG"));

        allQuestions.add(new Questions("\"Bailando\" (English: \"Dancing\") is a song by which Spanish singer ?", "Enrique", "Iglesias", "SMERILQEI", "SGAEGNUIO", "OGM"));

        //a_maingame 2 #
        allQuestions.add(new Questions("\"Hips Don't Lie\" is a song by which Colombian singer and songwriter ? \n she is highly popular award winning Columbian pop singer and dancer.", "SHAKIRA", "", "YRKVIAH", "SUWAUIY", "WIYUVUY"));

        allQuestions.add(new Questions("First President of the United states, who led the country to victory in the American Revolutionary War, Name him", "GEORGE", "WASHINGTON", "GAWOOETEH", "NHSJRIGNG", "JH"));

        allQuestions.add(new Questions("______ also known by his ring name 'The Rock', is an American actor, producer, singer, and professional wrestler.", "DWAYNE", "JOHNSON", "DNWJNEZVA", "SKOOYNHIG", "IKZVG"));

        allQuestions.add(new Questions("Who was awarded the Mark Twain Prize for American Humor (2015) by the John F. Kennedy Center ?", "EDDIE", "MURPHY", "DDUDIHRED", "MYMEYPPKE", "YDDKPME"));

        allQuestions.add(new Questions("“Eureka” was the word that he uttered in excitement, now forms the state motto of California. he was one of the greatest scientists & mathematicians, Name him", "ARCHIMEDES", "", "APRCMUIH", "ODSGEETV", "OGPTVU"));

        allQuestions.add(new Questions("Guess: A professional German retired car racer who has won the ‘Formula One’ championship on seven occasions.", "MICHAEL", "SCHUMACHER", "ALHUCERKE", "CCSMHIAHM", "K"));

        allQuestions.add(new Questions("In 2015, Who became the second-youngest person to become Prime Minister of Canada ?", "JUSTIN", "TRUDEAU", "LIQUUUREO", "BJTTNSIAD", "OIQBL"));

        allQuestions.add(new Questions("Who is first daughter of the president Donald Trump and his first wife former model Ivana Trump ?", "Ivanka", "Trump", "APMONTYTO", "VIKYGNAUR", "YNOOGYT"));

        allQuestions.add(new Questions("Which talented talk show host is now considered to be the wealthiest African-American woman in the United States ?\nHint :In 2013, she was awarded the ‘Presidential Medal of Freedom’.", "OPRAH", "WINFREY", "WRHONIONY", "ITHFRAPEE", "NHOTEI"));

        allQuestions.add(new Questions("Which American comedian starred in the popular sitcom Ellen from 1994 to 1998 and has also won Presidential Medal of Freedom in 2016 ?", "ELLEN", "DEGENERES", "NLESDYHLE", "RNFGEEEBE", "BFHY"));

        allQuestions.add(new Questions("Who is an American singer, rapper, songwriter, businessman, record producer and actor of Senegalese descent ?", "AKON", "", "ONIVZY", "KMKDQA", "VYKMQDZI"));

        allQuestions.add(new Questions("_______ was a Scottish biologist and pharmacologist who discovered enzyme lysozyme and antibiotic penicillin.", "ALEXANDER", "FLEMING", "AXELDQIAM", "EOGRNNLFE", "QO"));

        allQuestions.add(new Questions("Her portrayal of Rachel Green from American sitcom \"Friends\" made her a fashion icon and the hairstyle she wore began to be called ‘the Rachel’.Name her.", "JENNIFER", "ANISTON", "SJNUNTIEO", "FELANORIN", "ULO"));

        allQuestions.add(new Questions("\"Aubrey _______ Graham\" is a Canadian rapper, singer, songwriter, record producer, and actor.\nHis songs include \"Hotline Bling\",\"One Dance\",\"Over\" etc.", "DRAKE", "", "RDIKNE", "OXPNUA", "NOIUPXN"));

        allQuestions.add(new Questions("______ is an American businessman who co-founded Twitter.", "JACK", "DORSEY", "KHOQECHD", "RUKYJASR", "QKUHHR"));

        allQuestions.add(new Questions("Which sportsmen was honored as one of the 50 Greatest Players in NBA History in 1996 ?", "MAGIC", "JOHNSON", "JMNCMHGAE", "OEJODSICN", "MECEJD"));

        allQuestions.add(new Questions("Who is the 266th Pope of the Roman Catholic Church ?", "POPE", "FRANCIS", "KCPEFRWJS", "AFESIPONQ", "WSJKQEF"));

        allQuestions.add(new Questions("Who was an Italian explorer and navigator after whom the Americas were named ?", "AMERIGO", "VESPUCCI", "GPMCWVCEA", "MIURSIOEZ", "WMZ"));

        allQuestions.add(new Questions("Who is current CEO of Google Inc ?\nHe was also one of the top contenders for the post of CEO at Microsoft, which ultimately went to Satya Nadella.", "SUNDAR", "PICHAI", "TIPNRSACU", "DCZBYHIAZ", "YCTZZB"));

        allQuestions.add(new Questions("A Jewish victim of the Holocaust, was the author of ‘The Diary of a Young Girl’, Name her", "ANNE", "FRANK", "CFREAYNN", "WFKNBQPA", "YCWPQFB"));

        allQuestions.add(new Questions("Which famous golfer is of mixed African American, Native American, Chinese, Thai and Dutch ancestry ?", "TIGER", "WOODS", "OWQDHEST", "GPOHIHOR", "HHQPHO"));

        allQuestions.add(new Questions("Who's album ‘Blonde on Blonde’ was one of his first major hits. It peaked at No. 9 on the Billboard 200 chart in the US and No. 3 in the UK ?", "BOB", "DYLAN", "NOGBLCJ", "YWZBADB", "WGCJBZ"));

        allQuestions.add(new Questions("Who was named an ambassador for the 2012 World Humanitarian Day campaign for which she donated her song ‘I Was Here’ and its music video ?", "BEYONCE", "", "TWCYQZE", "NBOCERZ", "WCZTQZR"));

        allQuestions.add(new Questions("Who won the British Supporting Actress of the Year at the London Critics Circle Film Awards for her role in ‘The Last Days of Disco’ in the year 1999 ?", "KATE", "BECKINSALE", "TICKEPBAS", "ESKBELNCA", "CBSP"));

        allQuestions.add(new Questions("Who is a popular world pop icon, known for songs like ‘Poker Face’ & 'Bad Romance' ?", "LADY", "GAGA", "AABDGEG", "ASGYCCL", "SEGCCB"));

        allQuestions.add(new Questions("_____ is a Hollywood star best known for his performances in movies like the ‘Die Hard’ series and ‘Pulp Fiction’.", "BRUCE", "WILLIS", "CDWLYRBPL", "SISJWRUIE", ""));

        allQuestions.add(new Questions("Famous American actor, known for his movies, ‘Ocean’s Eleven’, ‘The Curious Case of Benjamin Button’, and ‘World War Z’, Name the actor.", "BRAD", "PITT", "DGAZRRL", "BTDITPW", "WGRZLD"));

        allQuestions.add(new Questions("Who won his second ‘Oscar’ in 2012 as a producer of ‘Argo’ ?", "GEORGE", "CLOONEY", "PLGOEOZRC", "GUENEYEOR", "PREUZ"));

        allQuestions.add(new Questions("The term rock 'n' roll was coined by whom ?", "Alan", "Freed", "ARMASNEF", "EHADDXLR", "RSDXAMH"));

        allQuestions.add(new Questions("Who is the founder and current CEO of Amazon.com ?", "JEFF", "BEZOS", "BAFIBOES", "EKJFEOZL", "EKALIBO"));

        allQuestions.add(new Questions("Which Hollywood actor loves to collect typewriters and has 80 of them in his collection ?", "TOM", "HANKS", "STYQDNH", "OQCIMAK", "IDCQQY"));

        allQuestions.add(new Questions("Who was an American stand-up comedian and actor. Starting as a stand-up comedian in San Francisco and Los Angeles in the mid-1970s ?", "ROBIN", "WILLIAMS", "ORWOMTIAI", "LBLISOVVN", "VVTOO"));

        allQuestions.add(new Questions("\"Rabindranath ______\"(full name) Great Bengali poet was an admirer of Gandhi and was the one who gave him the name “Mahatma”, Name him.", "TAGORE", "", "TRNQLOE", "JGAYYLR", "NLYLRQYJ"));

        allQuestions.add(new Questions("\"Alexander ______ ______\"(full name) was a Scottish-American scientist and inventor, referred to as ‘Father of the Telephone’.", "GRAHAM", "BELL", "ALQGMFRM", "ERHLSABZ", "SFZQMR"));

        allQuestions.add(new Questions("______ is the wife of U.S. President Barack Obama and the first African-American as First Lady.", "MICHELLE", "OBAMA", "BLCFMEAML", "LIEOLMAHW", "FMLLW"));

        allQuestions.add(new Questions("The name \"_____\" is a shortened version of his real name ‘Vincent’. He received the nickname \"_______\" from his friends, who said he ran off diesel fuel, referring to his non-stop energy.", "VIN", "DIESEL", "IWDNLEOQ", "EVSMIDNZ", "OWDMQNZ"));

        allQuestions.add(new Questions("His main discoveries include the principles underlying electromagnetic induction, diamagnetism and electrolysis, Name him.", "MICHAEL", "FARADAY", "MAGRERIDR", "YFALHCAAQ", "GQRR"));

        allQuestions.add(new Questions("Famous a_maingame & the founder of ‘Marxism’ often swallowed opium to overcome the pain he endured due to his liver problems, Name him.", "KARL", "MARX", "NDLTXAR", "ARJXQMK", "QNDJXT"));

        allQuestions.add(new Questions("Nicknamed JFK and Jack, John F _____ served as the 35th President of the United States.", "KENNEDY", "", "EKADECY", "ZNNYIZE", "ZIAZYEC"));

        allQuestions.add(new Questions("The heart and brain of this famous writer have been removed from his body. His heart is in the ‘Bibliotheque Nationale’ in Paris and his brain has since been lost after being auctioned off, Name him.", "VOLTAIRE", "", "FXSOTLI", "VOEERAS", "ESFSXO"));

        allQuestions.add(new Questions("Who is regarded as the father of modern computers ?", "CHARLES", "BABBAGE", "WRCBEHBSL", "AGABBHAZE", "ZHBW"));

        allQuestions.add(new Questions("Who rose to stardom with roles in The Mask (1994), My Best Friend's Wedding (1997) and There's Something About Mary (1998), and is also known for voicing the character of Princess Fiona in the Shrek series (2001–10) ?", "CAMERON", "DIAZ", "ODCEIQMKA", "ZIRJAIDJN", "JQIDKIJ"));

        allQuestions.add(new Questions("Starring roles as Han Solo in the Star Wars film series and as the title character of the Indiana Jones film series has gained him worldwide fame, Name him", "HARRISON", "FORD", "FROSTRORO", "FLNWIDHAR", "TFORWL"));

        allQuestions.add(new Questions("His start in stand-up comedy began at the 'hungry i' in San Francisco and was followed by his landing a starring role in the 1960s television show I Spy, Name him", "BILL", "COSBY", "FLBLTBOM", "YCHCKSIY", "HTFMKYC"));

        allQuestions.add(new Questions("One of Ancient Rome's most famous individuals, He was a statesman who changed the face of Rome, Name this genius.", "JULIUS", "CAESAR", "ABLSLEIRU", "IJUCSAECM", "MBCLEI"));

        allQuestions.add(new Questions("Who gained worldwide recognition for her ten-season run as Phoebe Buffay on the television sitcom \"Friends\" ?", "LISA", "KUDROW", "DUWFUKFI", "ODSBARLL", "FDBFLU"));

        allQuestions.add(new Questions("One of the founding fathers of the USA, _______ was a multi-talented a_maingame. He was a scientist, inventor, author, musician and a statesman.", "BENJAMIN", "FRANKLIN", "LBRMJHFNF", "INENKNIAA", "FH"));

        allQuestions.add(new Questions("Who was a singer & actor, known as ‘The king of Rock and Roll’ ?", "ELVIS", "PRESLEY", "VSYPDSHRE", "LWAOBEILE", "WHOADB"));

        allQuestions.add(new Questions("Who's roles in films like ‘Punch-Drunk Love’ and ‘The Wedding Singer’ are well known ?", "ADAM", "SANDLER", "NMNAUXDER", "SDLAZCAQN", "NNZXQUC"));

        allQuestions.add(new Questions("An Italian physicist who made major contributions to the development of nuclear energy ?", "ENRICO", "FLEMING", "YLNEHICRT", "NEIMGFOLN", "HYTLN"));

        allQuestions.add(new Questions("Which actress is best known for her role in the film ‘Breakfast at Tiffany’s’ as Holly Golightly ?", "AUDREY", "HEPBURN", "RUEENBFOH", "UDKSAEPRY", "SOKEF"));

        allQuestions.add(new Questions("Which famous mathematician and astronomer was the first to discover that the earth revolves around the sun and not the other way round ?", "Nicolaus", "Copernicus", "NCOSICPUO", "LIRNCESUA", ""));

        allQuestions.add(new Questions("_______, Prince of Wales is the eldest child and heir apparent of Queen Elizabeth II.", "CHARLES", "", "BLTAHPU", "CESRQIF", "TPIUBFQ"));

        allQuestions.add(new Questions("Which activist is the youngest ever recipient of the Nobel Prize & the only Pakistani winner of the Nobel Peace Prize ?", "MALALA", "YOUSAFZAI", "ZALWMIAAQ", "YSOLFABUA", "QBW"));

        allQuestions.add(new Questions("In 2009, _____ and Beyoncé were ranked as Hollywood’s top-earning couple by Time Magazine.", "JAY", "Z", "AGNHRS", "ZJJEFY", "HRNEJSFG"));

        allQuestions.add(new Questions("Which famous actress and singer-songwriter has her own clothing line called, ‘Wet Seal’ ?", "JESSICA", "SIMPSON", "SSPINCEMP", "APEISSQOJ", "PEPQ"));

        allQuestions.add(new Questions("Which great ex-President of US was awarded the Nobel Peace Prize 1919, in recognition of his efforts in the formation of the League of Nations ?", "WOODROW", "WILSON", "RDIQSOODO", "WNLSWUXWO", "DQSUX"));

        allQuestions.add(new Questions("Who formed a successful partnership with Matthew Boulton to build steam engines ?", "James", "Watt", "USTWMEDA", "TJWHDASZ", "ZHWDSDU"));

        allQuestions.add(new Questions("Which explorer's last words were 'I am just going outside, and may be some time' ?", "Laurence", "Oates", "NETSRLLEW", "SOAUTEACN", "LNTSW"));

        allQuestions.add(new Questions("The political theory derived from the teachings of who's Marxist-Leninst leader of China is called Maoism ?", "MAO", "ZEDONG", "VGEYCGNA", "VNOMZDOH", "VCVHGYN"));

        //a_maingame hard

        allQuestions.add(new Questions("One of the most prominent female politicians of the United States & was the 67th United States Secretary of State, Name her.", "HILLARY", "CLINTON", "NAYTROIBL", "SCLLIHNLH", "SHLB"));

        allQuestions.add(new Questions("Who is the co-founder and promoter of Wikipedia, the online non-profit encyclopedia ?", "JIMMY", "WALES", "KIBKPUMY", "JAPLESMW", "PPKKBU"));

        allQuestions.add(new Questions("Who was the first to establish the concept that all species descended from common ancestors and that the branching pattern of evolution resulted from a process which he termed natural selection ?", "CHARLES", "DARWIN", "YGWLITCNA", "DRARHSADE", "AYDGT"));

        allQuestions.add(new Questions("Who was called the Godfather of Soul ?", "James", "brown", "EWBSURAU", "OMSANAWJ", "WASUUA"));

        allQuestions.add(new Questions("An American politician and soldier who served as the first President of the United States from 1789 to 1797.\nName him.", "GEORGE", "WASHINGTON", "TREGOIWGE", "GNLOSNHEA", "EL"));

        allQuestions.add(new Questions("Which professional tennis player is popularly referred to as Fed Express or FedEx. People even call him Swiss Maestro or simply Maestro for his exceptional skills at the game ?", "ROGER", "FEDERER", "GFRDOQEMM", "REESBERLR", "LMBQMS"));

        allQuestions.add(new Questions("As the current CEO of Microsoft, he is one of the most powerful Indian-born tech executives in the world. Name him.", "SATYA", "NADELLA", "LAAYJEYVL", "AATSVBIDN", "YVIJVB"));

        allQuestions.add(new Questions("Who is most known for his work in the study of black holes. With the theoretical prediction that black holes emit radiation, a theory called ‘Hawking radiation’ ?", "STEPHAN", "HAWKING", "HHNETNNWI", "KKAPAGBES", "BKEN"));

        allQuestions.add(new Questions("In 1999, Scottish actor ________ received a Kennedy Center Honor for Lifetime Achievement and was knighted by the Queen Elizabeth II in July 2000.", "SEAN", "CONNERY", "CNRNMONSA", "GEOYLQDES", "GSQODLM"));

        allQuestions.add(new Questions("Before serving as the 33rd Governor of California and the 40th President of the United States, which iconic politician was a radio sports announcer and an actor ?", "RONALD", "REAGAN", "OQDANEGRN", "LARAZPACP", "QPAPZC"));

        allQuestions.add(new Questions("Who is the software engineer who created the Linux kernel operating system ?", "LINUS", "TORVALDS", "SSLFUNAOH", "IRDTLVICS", "SICFH"));

        allQuestions.add(new Questions("Who is widely regarded as the father of India's space programme ?", "Vikram", "Sarabhai", "IFAARVBWA", "HAKRMIABS", "WBFA"));

        allQuestions.add(new Questions("An American model, actress, and television a_maingame. \"______ ______ Smith\" first gained popularity in Playboy, winning the title of 1993 Playmate of the Year.", "ANNA", "NICOLE", "CNNICKVO", "NLOQAEAV", "VKCOQV"));

        allQuestions.add(new Questions("Who is an Academy Award winning actor known for his work in movies like ‘Street Smart’, ‘Driving Miss Daisy’ and ‘Million Dollar Baby’ ?", "MORGAN", "FREEMAN", "ENMFNORRA", "GAIVSGEJM", "GJIVS"));

        allQuestions.add(new Questions("Who was the film star who married Prince Rainier III of Monaco ?", "Grace", "Kelly", "YAZSGEKR", "ACGTELLE", "GZSATE"));

        allQuestions.add(new Questions("An illustrious musician, songwriter, singer, actor and the founding member of ‘The Rolling Stones’, Name him.", "MICK", "JAGGER", "XMRGICGE", "KEJYPALN", "XPENLY"));

        allQuestions.add(new Questions("Who is the first woman to be awarded with the prestigious Nobel Prize and the only to win it in two field and multiple sciences. She is responsible for coining the term radioactivity ?", "MARIE", "CURIE", "MFTYZEIR", "ORUUECAI", "ZFOTYU"));

        allQuestions.add(new Questions("In 2017, as the Policing and Crime Act 2017 was enacted in UK, Wilde was officially pardoned for his offence as homosexuality is no longer a crime in England, Name him", "OSCAR", "WILDE", "SACAZLTE", "WRWGTDOI", "TAWGZT"));

        allQuestions.add(new Questions("Who was a famous English chemist and pioneer x-ray crystallographer who unravelled the structure of DNA and RNA ?", "ROSALIND", "FRANKLIN", "INKFLOWNR", "LTAIDRANS", "WT"));

        allQuestions.add(new Questions("\"______\" is an American actor and filmmaker,has won the Academy Award for Best Actor twice, one for the drama  \"One Flew Over the Cuckoo's Nest (1975)\" and the other for the romantic comedy \"As Good as It Gets (1997)\".", "JACK", "NICHOLSON", "ENAKHVONS", "CIDCJONLE", "EVDNE"));

        allQuestions.add(new Questions("Who is the founder of the Ferrari automobile marquee ?", "ENZO", "FERRARI", "RYETORNAZ", "RIEEAFRQR", "ATQERRY"));

        allQuestions.add(new Questions("In partnership with the Hawai'i Community Foundation and the GRAMMY Foundation, Who has established a GRAMMY Camp Scholarship Fund, in order to provide financial assistance to next generation of music makers ?", "BRUNO", "MARS", "MYJUVBBN", "MAMSRROL", "JVMYBML"));

        allQuestions.add(new Questions("Who was an American attorney, planter and politician who became known as an orator during the movement for independence in Virginia ?", "PATRICK", "HENRY", "IFARRHLKC", "TREPWNAEY", "RWLAFE"));

        allQuestions.add(new Questions("Who is an American business magnate, investor and philanthropist. He is best known as the co-founder of Microsoft, alongside Bill Gates ?", "PAUL", "ALLEN", "ELVLUNOQ", "XQVOLAAP", "VOXVOQQ"));

        allQuestions.add(new Questions("Which lady astronaut formerly held the records for total spacewalks by a woman and most spacewalk time for a woman ?", "SUNITA", "WILLIAMS", "LLSMWJIPC", "UTIIASDAN", "CPJD"));

        allQuestions.add(new Questions("Who is an Indian-born American business executive currently serving as the Chairperson and Chief Executive Officer of PepsiCo ?", "INDRA", "NOOYI", "NNOBRALE", "OIYKEJID", "EKELJB"));

        allQuestions.add(new Questions("Who is an American information technology executive, currently serving as the CEO of Yahoo ?\nA position she has held since July 2012.", "MARISSA", "MAYER", "MAPAREKCA", "MYGASISRY", "GKAYCP"));

        allQuestions.add(new Questions("This British born actress used to keep her Oscar statuettes in her bathroom but had to move them to make room for her daughter’s artwork. Name her.", "EMMA", "THOMPSON", "ETNAMYGMR", "POSNDUMOH", "NYGDRU"));

        allQuestions.add(new Questions("Scottish economist, philosopher, and author. He was a moral philosopher, a pioneer of political economy, and was a key figure during the Scottish Enlightenment era. Name him.", "ADAM", "SMITH", "VSMDFMRI", "SHAATDAT", "FSRDTVA"));

        allQuestions.add(new Questions("Who led a government in Italy in the 20s and later became its dictator ?", "Mussolini", "", "BNSMLXIJ", "OUBISSYI", "BIBXJYS"));

        allQuestions.add(new Questions("Which Austrian wrote \"The Psychopathology of Everyday Life\" ?", "Sigmund", "Freud", "SUGSFPEDD", "QRJINCMUU", "UQJPSC"));

        allQuestions.add(new Questions("A pop musician who laid the foundation for rock and roll music in America. Name him.", "LITTLE", "RICHARD", "PACCRDLTI", "THRDERLDI", "DPRCD"));

        allQuestions.add(new Questions("Best known as the host of the award winning news show, CNN’s ‘______ _____ 360’.", "ANDERSON", "COOPER", "QPTONNAZS", "XCDROREEO", "ZQXT"));

        allQuestions.add(new Questions("Jersey No. 12, which _______ held in the Pittsburgh Steelers, has not been reissued to any player, post his retirement.", "TERRY", "BRADSHAW", "SEURJHADT", "RABWKDRUY", "JDUKU"));

        allQuestions.add(new Questions("Who is American civil rights activist, Baptist minister, and politician who was also a candidate for the Democratic presidential nomination in 1984 and 1988 ?", "JESSE", "JACKSON", "KNOSSZOJA", "JELCSNJEK", "OKJLNZ"));

        allQuestions.add(new Questions("Who was awarded the Presidential Medal of Freedom, the highest civilian honor in USA in the year 2002 by George W. Bush ?\n The award was given in recognition to his contribution to the welfare of children.", "FRED", "ROGERS", "EORRFWEP", "TKSVRCGD", "VWCTPK"));

        allQuestions.add(new Questions("One of the strongest political leaders of Independent India, she was the first woman to hold the office of the Prime Minister, Name her.", "INDIRA", "GANDHI", "IADVDNIRN", "LGDXRIABH", "XDLRVB"));

        allQuestions.add(new Questions("Who is the co-founder and CEO of the American multinational technology and social media company Snap Inc..,which he created (as Snapchat Inc.) ?", "EVAN", "SPIEGEL", "PIELEINSY", "GIVEATJLE", "ITIYJEL"));

        allQuestions.add(new Questions("Katheryn Elizabeth Hudson, known professionally as ______, is an American singer and songwriter. After singing in church during her childhood, she pursued a career in gospel music as a teenager.", "KATY", "PERRY", "AEEYKKPD", "URTKRYDL", "KLDDEKU"));

        allQuestions.add(new Questions("Who was the woman who played the biggest role in instigating the French Revolution ?\nShe was the last queen of France.", "MARIE", "ANTOINETTE", "TTNEPTEFA", "AIIMETNRO", "TFP"));

        allQuestions.add(new Questions("Who was a Georgian-Soviet revolutionary, politician and political theorist. He governed the Soviet Union from the mid-1920s until his death in 1953 ?", "JOSEPH", "STALIN", "JJTHAJHON", "OPIOSBSLE", "HBOJOJ"));

        allQuestions.add(new Questions("Who was a philosopher, statesman, scientist, jurist, orator, and author who served both as Attorney General and as Lord Chancellor of England ?", "FRANCIS", "BACON", "IPOSAAABR", "NFNSNCCCE", "CASNEP"));

        allQuestions.add(new Questions("Canadian Prime Minister was awarded a 2nd dan black belt in judo by the Takahashi School of Martial Arts in Ottawa. Name him.", "PIERRE", "TRUDEAU", "RRTPARURI", "UEEELCDQW", "RLWCQ"));

        allQuestions.add(new Questions("______ is a computer programmer and author. He created the Perl programming language. Name him", "LARRY", "WALL", "JRKUBLAB", "AUWRWYLL", "JBUUWKB"));

        allQuestions.add(new Questions("According to The Discovery Channel show ‘Chasing Classic Cars’, it is believed that _______ American stand-up comedian owns the first and last air-cooled Porsche 911s produced.", "JERRY", "SEINFELD", "LRYMTSVFR", "KNIEENDEJ", "NTMKV"));

        allQuestions.add(new Questions("One of the co-founders of the rock band The Beatles was returning home with his wife on 8 December 1980 when Mark David Chapman shot him in the back four times. He was rushed to the hospital but was pronounced dead on arrival. Name him.", "JOHN", "LENNON", "ELLNOJHR", "EONZNTND", "RZTELD"));

        allQuestions.add(new Questions("She was named by the American Film Institute as the greatest female star of Classic Hollywood Cinema in 1999.\nShe was leading lady in Hollywood for more than 60 years.\nShe died on June 29, 2003 (aged 96),Name her.", "KATHARINE", "HEPBURN", "TEPRHAHKN", "RAIUBNEUI", "UI"));

        allQuestions.add(new Questions("Who is best known as the father of the Java programming language ?", "JAME", "GOSLING", "NOJMXIGNC", "AQGESQLWL", "QCQXNWL"));

        allQuestions.add(new Questions("Who was a French theologian & pastor who played an important role in the Protestant Reform movement ?", "JOHN", "CALVIN", "BAIMJNOD", "CNZLVMHL", "LMBMZD"));

        allQuestions.add(new Questions("Who was the thirty-seventh President of the United States and the only President to ever resign from office ?", "RICHARD", "NIXON", "HICRIRORM", "UGDEACNNX", "RUCEGM"));

        allQuestions.add(new Questions("Who is a French former actress and fashion model who later became an animal rights activist ?", "BRIGITTE", "BARDOT", "WRIEBOBYR", "PSTDTIGAT", "SPWY"));

        allQuestions.add(new Questions("Who was the fifth President of Iraq, serving from 16 July 1979 until 9 April 2003 ?", "SADDAM", "HUSSEIN", "NEBDASSUS", "IZSADHSJM", "JBSSZ"));

        allQuestions.add(new Questions("Guess: A French military and political leader who rose to prominence during the French Revolution.", "NAPOLEON", "BONAPARTE", "PNATNLOON", "APEARBEZO", "Z"));

        allQuestions.add(new Questions("Who was an Italian Dominican theologian hailed as the father of the Thomistic school of theology ?", "THOMAS", "AQUINAS", "SQAASXIOF", "VATNHUARM", "VFXRA"));

        allQuestions.add(new Questions("In 2007, who's wax statue was installed at the ‘Madame Tussauds’ museum, London, which made him the third Indian actor to earn a spot at this prestigious place ?", "SHAHRUKH", "KHAN", "KNRFHKHAO", "SBFAHVEHU", "EVFFBO"));

        allQuestions.add(new Questions("A Russian cosmonaut \"_____ Tereshkova(surname)\" created history when she became the first woman to travel to space.", "VALENTINA", "", "BTENBVNA", "AAGBLYLI", "BBGLYBA"));

        allQuestions.add(new Questions("As a World War II veteran, who was the recipient of numerous prestigious awards including Asiatic-Pacific Campaign Medal, American Campaign Medal, and World War II Victory Medal ?", "GERALD", "FORD", "ERXEGPXR", "DDAFLJOF", "FPXJEX"));

        allQuestions.add(new Questions("Who joined hands with Fidel Castro and played an important and crucial role in the Cuban Revolution. For his revolutionary actions and rebellions nature, he became an iconic cultural hero ?", "CHE", "GUEVARA", "EREAVUCG", "SLRNHAZF", "ZRNLSF"));

        allQuestions.add(new Questions("______ is the reigning Emperor of Japan. He is the 125th emperor of his line according to Japan's traditional order of succession.", "AKIHITO", "", "ICBLTMU", "KHAOEIV", "ELUMBCV"));

        allQuestions.add(new Questions("Who was the Prime Minister of the United Kingdom from 1940 to 1945 and again from 1951 to 1955 ?", "WINSTON", "CHURCHILL", "SWLRCUCNI", "IOLTKWHHN", "KW"));


        this.addAllQuestions(allQuestions);

        /* Toast.makeText(context,"addquestions",Toast.LENGTH_SHORT).show();*/
    }




    public void addAllQuestions(ArrayList<Questions> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (Questions question : allQuestions) {
                values.put(QUESTION, question.getQUESTION());
                values.put(ANSWER, question.getANSWER());
                values.put(ANSWER2, question.getANSWER2());
                values.put(RANDOMANS1, question.getRANDOMANS1());
                values.put(RANDOMANS2, question.getRANDOMANS2());
                values.put(USELESSSTRING, question.getUSELESSSTRING());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    //It will return the list of address and throw that address we gonna excess each field in it
   public List<Questions> getAllOfTheQuestions() {

        List<Questions> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, ANSWER, ANSWER2, RANDOMANS1, RANDOMANS2, USELESSSTRING};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            Questions question = new Questions();
            question.setID(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setAnswer(cursor.getString(2));
            question.setAnswer2(cursor.getString(3));
            question.setRANDOMANS1(cursor.getString(4));
            question.setRANDOMANS2(cursor.getString(5));
            question.setUSELESSSTRING(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    //It will insert the qid of solved questions
    public void InsertQid(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CORRECTNO, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME2, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
       /* Toast.makeText(context,"the answer was correct"+id+"was added",Toast.LENGTH_SHORT).show();*/
        db.close();
    }

    //It will return the list of qid of which question is solved
    public List<Integer> GetQid() {
        String coloumns[] = {CORRECTNO};
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME2, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list.add(questionId);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    //It will insert the qid for which FreeHint is used
    public void insertHint(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(HINTID, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME3, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list of qid of which FreeHint is used
    public List getHint() {
        String coloumns[] = {HINTID};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME3, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int hintId = cursor.getInt(0);
            list.add(hintId);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }


    public void insertRandomNumbers(int id,int one , int two ,int three , int four , int five) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(ONE, one);
        contentValues.put(TWO, two);
        contentValues.put(THREE, three);
        contentValues.put(FOUR, four);
        contentValues.put(FIVE, five);

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME4, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public List<FreeHint> getRandomNumbers() {
        String coloumns[] = {ID,ONE,TWO,THREE,FOUR,FIVE};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME4, coloumns, null, null, null, null, null);
        List<FreeHint> FreeHintNoList = new ArrayList<>();

        while (cursor.moveToNext()) {
            FreeHint freeHint = new FreeHint();
            freeHint.setFreeHintUsedId(cursor.getInt(0));
            freeHint.setRandomNoOne(cursor.getInt(1));
            freeHint.setRandomNoTwo(cursor.getInt(2));
            freeHint.setRandomNoThree(cursor.getInt(3));
            freeHint.setRandomNoFour(cursor.getInt(4));
            freeHint.setRandomNoFive(cursor.getInt(5));
            FreeHintNoList.add(freeHint);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return FreeHintNoList;
    }

    //pause button of slider
    public void insertPauseValue(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(storePauseValue, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME11, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public List getPauseButtonValue() {
        String coloumns[] = {storePauseValue};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME11, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int pauseValue = cursor.getInt(0);
            list.add(pauseValue);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    //Insert the qid of which boom is used
    public void insertBoom(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOM, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME12, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return list of qid of which boom is used
    public List getBoomId() {
        String coloumns[] = {BOOM};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME12, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int boomValue = cursor.getInt(0);
            list.add(boomValue);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    //It will delete all the records i.e reset the game
    public void deleteAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.execSQL("delete from " + TABLE_NAME2);
        db.execSQL("delete from " + TABLE_NAME3);
        db.execSQL("delete from " + TABLE_NAME4);
        //db.execSQL("delete from " + TABLE_NAME5);
        //db.execSQL("delete from " + TABLE_NAME6);
       /* db.execSQL("delete from " + TABLE_NAME7);*/
        db.execSQL("delete from " + TABLE_NAME8);
        //db.execSQL("delete from " + TABLE_NAME9);
        //db.execSQL("delete from " + TABLE_NAME10);
        db.execSQL("delete from " + TABLE_NAME11);
        db.execSQL("delete from " + TABLE_NAME12);
        db.execSQL("delete from " + TABLE_NAME13);
        db.execSQL("delete from " + TABLE_NAME14);
        db.close();
    }

    public void InsertGems(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(GEMS, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME8, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //The no at the end of list is the latest value of gem
    public List getGems() {
        String coloumns[] = {GEMS};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME8, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();
        list2.add(42);

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }


    public void insertSound(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SOUND, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME13, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list. if list size is even dialog_sound is on or else off
    public List getSound() {
        String coloumns[] = {SOUND};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME13, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }

    //It will insert value "1" so we will come to know that questions are added by checking size
    public void insertCheckQadded(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CHEKQADDED, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME14, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list which has value "1" if the question are added in the table
    //so will check the size of list if it is greater than zero means que are added
   public  List getCheckQadded() {
        String coloumns[] = {CHEKQADDED};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME14, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }

}