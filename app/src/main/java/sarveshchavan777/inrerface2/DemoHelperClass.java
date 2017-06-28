package sarveshchavan777.inrerface2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class DemoHelperClass extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Context context;
    private static final String DATABASE_NAME = "DEMOGAMEDBB";

    static int DATABASE_VERSION = 816;
    static final String TABLE_NAME = "TRIVIAQUIZ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTION1 = "OPTION1";
    private static final String ANSWER = "ANSWER";
    private static final String ANSWER2 = "ANSWER2";
    private static final String RANDOMANS1 = "RANDOMANS1";
    private static final String RANDOMANS2 = "RANDOMANS2";
    private static final String USELESSSTRING = "USELESSSTRING";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTION1 + " VARCHAR(255), " + ANSWER + " VARCHAR(255), " + ANSWER2 + " VARCHAR(255), " + RANDOMANS1 + " VARCHAR(255), " + RANDOMANS2 + " VARCHAR(255), " + USELESSSTRING + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    static String TABLE_NAME2 = "TRIVIAQUIZ2";
    private static final String CORRECTNO = "CORRECTNO";
    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ( " + CORRECTNO + " INTEGER );";
    private static final String DROP_TABLE2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;

    static String TABLE_NAME3 = "TRIVIAQUIZ3";
    private static final String HINTID = "HINTID";
    private static final String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME3 + " ( " + HINTID + " INTEGER );";
    private static final String DROP_TABLE3 = "DROP TABLE IF EXISTS " + TABLE_NAME3;
    private static final String DELETE_TABLE3 = " DELETE FROM " + TABLE_NAME3;

    static String TABLE_NAME4 = "TRIVIAQUIZ4";
    private static final String AONE = "AONE";
    private static final String CREATE_TABLE4 = "CREATE TABLE " + TABLE_NAME4 + " ( " + AONE + " INTEGER );";
    private static final String DROP_TABLE4 = "DROP TABLE IF EXISTS " + TABLE_NAME4;

    static String TABLE_NAME5 = "TRIVIAQUIZ5";
    private static final String ATWO = "ATWO";
    private static final String CREATE_TABLE5 = "CREATE TABLE " + TABLE_NAME5 + " ( " + ATWO + " INTEGER );";
    private static final String DROP_TABLE5 = "DROP TABLE IF EXISTS " + TABLE_NAME5;

    static String TABLE_NAME6 = "TRIVIAQUIZ6";
    private static final String ATHREE = "ATHREE";
    private static final String CREATE_TABLE6 = "CREATE TABLE " + TABLE_NAME6 + " ( " + ATHREE + " INTEGER );";
    private static final String DROP_TABLE6 = "DROP TABLE IF EXISTS " + TABLE_NAME6;

   /* static String TABLE_NAME7 = "TRIVIAQUIZ7";
    private static final String DOLLAR = "DOLLAR";
    private static final String CREATE_TABLE7 = "CREATE TABLE " + TABLE_NAME7 + " ( " + DOLLAR + " INTEGER );";
    private static final String DROP_TABLE7 = "DROP TABLE IF EXISTS " + TABLE_NAME7;*/

    static String TABLE_NAME8 = "TRIVIAQUIZ8";
    private static final String GEMS = "GEMS";
    private static final String CREATE_TABLE8 = "CREATE TABLE " + TABLE_NAME8 + " ( " + GEMS + " INTEGER );";
    private static final String DROP_TABLE8 = "DROP TABLE IF EXISTS " + TABLE_NAME8;

    static String TABLE_NAME9 = "TRIVIAQUIZ9";
    private static final String AFOUR = "AFOUR";
    private static final String CREATE_TABLE9 = "CREATE TABLE " + TABLE_NAME9 + " ( " + AFOUR + " INTEGER );";
    private static final String DROP_TABLE9 = "DROP TABLE IF EXISTS " + TABLE_NAME9;

    static String TABLE_NAME10 = "TRIVIAQUIZ10";
    private static final String AFIVE = "AFIVE";
    private static final String CREATE_TABLE10 = "CREATE TABLE " + TABLE_NAME10 + " ( " + AFIVE + " INTEGER );";
    private static final String DROP_TABLE10 = "DROP TABLE IF EXISTS " + TABLE_NAME10;

    static String TABLE_NAME11 = "TRIVIAQUIZ11";
    private static final String storePauseValue = "storePauseValue";
    private static final String CREATE_TABLE11 = "CREATE TABLE " + TABLE_NAME11 + " ( " + storePauseValue + " INTEGER );";
    private static final String DROP_TABLE11 = "DROP TABLE IF EXISTS " + TABLE_NAME11;

    static String TABLE_NAME12 = "TRIVIAQUIZ12";
    private static final String BOOM = "BOOM";
    private static final String CREATE_TABLE12 = "CREATE TABLE " + TABLE_NAME12 + " ( " + BOOM + " INTEGER );";
    private static final String DROP_TABLE12 = "DROP TABLE IF EXISTS " + TABLE_NAME12;

    static String TABLE_NAME13 = "TRIVIAQUIZ13";
    private static final String SOUND = "SOUND";
    private static final String CREATE_TABLE13 = "CREATE TABLE " + TABLE_NAME13 + " ( " + SOUND + " INTEGER );";
    private static final String DROP_TABLE13 = "DROP TABLE IF EXISTS " + TABLE_NAME13;

    public DemoHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
      /*  Toast.makeText(context,"DemoHelperClass",Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(CREATE_TABLE);
       sqLiteDatabase.execSQL(CREATE_TABLE2);
        sqLiteDatabase.execSQL(CREATE_TABLE3);
        sqLiteDatabase.execSQL(CREATE_TABLE4);
        sqLiteDatabase.execSQL(CREATE_TABLE5);
        sqLiteDatabase.execSQL(CREATE_TABLE6);

        sqLiteDatabase.execSQL(CREATE_TABLE8);
        sqLiteDatabase.execSQL(CREATE_TABLE9);
        sqLiteDatabase.execSQL(CREATE_TABLE10);
        sqLiteDatabase.execSQL(CREATE_TABLE11);
        sqLiteDatabase.execSQL(CREATE_TABLE12);
        sqLiteDatabase.execSQL(CREATE_TABLE13);
      // Toast.makeText(context,"oncreate called",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)     {
       // i=oldVersion i1=new newVersion
            sqLiteDatabase.execSQL(DROP_TABLE);
            sqLiteDatabase.execSQL(DROP_TABLE2);
            sqLiteDatabase.execSQL(DROP_TABLE3);
            sqLiteDatabase.execSQL(DROP_TABLE4);
            sqLiteDatabase.execSQL(DROP_TABLE5);
            sqLiteDatabase.execSQL(DROP_TABLE6);

            sqLiteDatabase.execSQL(DROP_TABLE8);
            sqLiteDatabase.execSQL(DROP_TABLE9);
            sqLiteDatabase.execSQL(DROP_TABLE10);
            sqLiteDatabase.execSQL(DROP_TABLE11);
            sqLiteDatabase.execSQL(DROP_TABLE12);
               sqLiteDatabase.execSQL(DROP_TABLE13);
    //   Toast.makeText(context,"onUpgrade called",Toast.LENGTH_LONG).show();
        onCreate(sqLiteDatabase);
    }

    public void addquestions() {
        ArrayList<Questions> allQuestions = new ArrayList<Questions>();

        allQuestions.add(new Questions("Who was the first African American to have served as president of United States of America ?", "BAROBAACKMAQCAEMBD", "BarACK", "ObaMA","BARIACKTE","OBMAMAPSF","ITEMPSF"));

        allQuestions.add(new Questions("Who co-founded Apple company with Steve Wozniak, Ronald Wayne ?", "TSOVWIBYUBZRGOEJSE", "STEVE", "JOBS","OAEESVSC","AWOBFOTJ","COAOFWA"));

        allQuestions.add(new Questions("Who was the first elected President of South Africa ?", "NSLLONSLMDKPQAEENA", "NELSON", "MANDELA","PNDAYLELS","ONNEWMCCA","CCYPW"));

        allQuestions.add(new Questions("Which German born physicist developed the Special theory of relativity which has the famous equation E = mc^2 ?", "NEANRESBAICNNTTEIL", "ALBERT", "EINSTEIN","ISTENIRTN","LERKELCBA","LRKC"));

        allQuestions.add(new Questions("Disneyland theme park located in US is the brainchild of which creative genius ?", "UHUYPLYZDIANTISEWC", "WALT", "DISNEY","ERISWYLA","DYTNLLVG","RVLGLY"));

        allQuestions.add(new Questions("Who is know as the 'King of Pop' ?", "IOKAYJLHCSMQCQNEYA", "MICHAEL", "JACKSON","MHJSCANCI","NDEDALKKO","KNDD"));

        allQuestions.add(new Questions("The war drama film ‘Born on the Fourth of July’ (1989) is one of best known movies of which actor ?", "HCMFSOBAIUIUCQQETR", "TOM","CRUISE","KCIUYMJR","SWGCETUO","KGWJYUC"));

        allQuestions.add(new Questions("Which cricketer is also know as 'God of Cricket'?", "HESLKTRHRIACUDAWNN", "SACHIN", "TENDULKAR","KDCINLRTE","HGATUHSAN","GTH"));

        allQuestions.add(new Questions("Who was the first man ever to walk on the surface of the Moon ?", "GEIMCAXIATNRNSROLR", "NEIL", "ARMSTRONG","MTOLCRGNX","CNREAPSIL","PCLXC"));

        allQuestions.add(new Questions("In 2015, who has been estimated to have a net worth of 1 billion dollars, setting the record of being the first billionaire athlete(Basketball player) ever ?", "CHEJHIQANAUFMLRDQO", "MICHAEL", "JORDAN","RNLIHAEMV","JDWJCOBCA","VWJBC"));

        allQuestions.add(new Questions("Who co-founded Microsoft company with  Paul Allen, which became the world's largest PC software company ?", "YUKGSACDEALTILCKBW", "BILL", "GATES","SLELIILS","TWSAOBPG","PWSILOS"));

        allQuestions.add(new Questions("At the 2008 Beijing olympics, which athlete won gold medals in 100m, 200m and 4x100m relay ?", "XTBYRNNWOIRTUIZAGS", "USAIN", "BOLT","NQODOLIV","AWPSTTBU","VTODQWP"));

        allQuestions.add(new Questions("In 2011 ‘The Karate Kid’ was remade starring  ______ & Jaden Smith in it. The movie was a big success at the box office, earning over 358 million US dollars.", "JAPCHEAAIDPHKKNYQC", "JACKIE", "CHAN","RRHREIAA","KCNZJAGC","ZGRRAR"));

        allQuestions.add(new Questions("\"_____ Schwarzenegger\"(surname) is an American actor popularly known as \"Terminator\" and was also the former Governor of California ?", "COLODCARWWSCPTYDNP", "ARNOLD", "","UDTOLRW","DNARVSO","SWOUDTVR"));

        allQuestions.add(new Questions("Who co-founded the social-networking website Facebook out of his college dorm room ?", "CCRMREKAUZGRYKZEBD", "MARK", "ZUCKERBERG","KDBERRUCK","EKGARZAOM","OKAD"));

        allQuestions.add(new Questions("Who founded the Missionaries of Charity in Calcutta(INDIA) with the objective of serving the poorest of the poor ?", "SRHAELEMGRTFETBHOE", "MOTHER", "TERESA","IEWPWRTHR","ESOTHEAMT","ITWWHP"));

        allQuestions.add(new Questions("She was posthumously honoured with the Congressional Space Medal of Honor, NASA Space Flight Medal and NASA Distinguished Service Medal. She was Indian American astronaut who died in the Space Shuttle Columbia disaster(2003),Guess her name.", "CHLKNWAPAAACLAKNLP", "KALPANA", "CHAWLA","DWHTACALN","PALOKAAPC","CODTP"));

        allQuestions.add(new Questions("Which famous chef revealed one of the secrets to his success thus, “If you want to become a great chef, you have to work with great chefs. And that's exactly what I did”.", "NOYORSDRRACZGANCMO", "GORDON", "RAMSAY","RXMNRAOQN","SABODMGFY","BXQNMF"));

        allQuestions.add(new Questions("Who became the First youtuber to hit 50 million subscribers ?", "MPPIRIERANEMFEEDWR", "PEWDIEPIE", "","PFWEIECD","IIDEETPC","CTDFICE"));

        allQuestions.add(new Questions("Who was a French biologist, microbiologist and chemist renowned for his discoveries of the principles of vaccination, microbial fermentation and pasteurization ?", "UEBAILRLTURZOSDPLS", "LOUIS", "PASTEUR","FQSIOBNVS","PTUURESLA","QFBSVN"));

        allQuestions.add(new Questions("The \"_____ brothers\", Orville and Wilbur, were two American brothers, inventors, and aviation pioneers who are generally credited with inventing, building, and flying the world's first successful airplane.", "HTWOGRLOHETINRBSTR", "WRIGHT", "","THXTWFI","RGLUVSX","VSTFLUXX"));

        allQuestions.add(new Questions("Who is the current President of the Russian Federation ?\nHe was Prime Minister from 1999 to 2000, President from 2000 to 2008, and again Prime Minister from 2008 to 2012.", "VLADIMIRPUTINAAAAA", "VLADIMIR", "PUTIN","TIXSKILPT","LNDAIMURV","LKSXT"));

        allQuestions.add(new Questions("Who was famous for his character \"The Tramp\" ?\n The sweet little man with a bowler hat, mustache and cane, he was an iconic figure of the silent-film era and one of film's first superstars.", "EILACHIAAHPHCLMRNI", "CHARLIE", "CHAPLIN","HHLACIBNJ","RPILVCAGE","VBJG"));

        allQuestions.add(new Questions("Who is a Polish-American technology executive and also the current CEO of YouTube ?", "SBCSKNOJABQICIQWUF", "SUSAN", "WOJCICKI","AIKSZNASC","WCUJBUAIO","BAAZU"));

        allQuestions.add(new Questions("Who is a famous American actor and singer, who is known for his performances in movies like ‘I am Legend’ and ‘Hancock’ ?", "TTOEILTWDLIYSNSHMM", "WILL", "SMITH","LGFTTHEI","JUILMWSV","TGEUFJV"));

        allQuestions.add(new Questions("Who is a famous Jamaican reggae singer, known for his album ‘Rastaman Vibration’ ?", "YBDALLJBAILOMFGREA", "BOB", "MARLEY","LOMWYSAE","RQBPBEEO","SEQWOPE"));

        allQuestions.add(new Questions("Who was the inventor of dynamite and a manufacturer of arms who left his vast fortunes to institute the Nobel Prizes ?", "BESLBANCEDORZFBLFO", "ALFRED", "NOBEL","BYNFALEHQ","EZDDLNERO","QZDENYH"));

        allQuestions.add(new Questions("Who is the 45th & current President of the United States. Before entering politics he was a businessman and television personality ?", "UHSPNTMRATDDFGQODL", "DONALD", "TRUMP","QOMRADLAD","UFTWCEYNP","EQWYFCA"));

        allQuestions.add(new Questions("Who was the infamous dictator of Germany who carried out the genocide of Jews and was majorly responsible for the World War II ?", "WLOTHGEIPUDFALRTHK", "ADOLF", "HITLER","PLCRELANH","FDIHFOKTE","PCFHKNE"));

        allQuestions.add(new Questions("An computer programmer and businessman who is best known as the co-founder and president of the video game development & digital distribution company Valve Corporation ?", "ELAEQREZENBWSLGEKL", "GABE", "NEWELL","TGNLLALN","WIKGBEEE","TIKNGL"));

        allQuestions.add(new Questions("In \"Harry Potter\" series which actor played the character of Harry Potter ?", "ACLEFEANDDKRPIFILI", "DANIEL", "RADCLIFFE","AXRLCDFDI","LEFNEADIU","XUD"));

        allQuestions.add(new Questions("In the Disney Channel television series \"Hannah Montana\" (2006) who became a teen idol starring as the character Miley Stewart ?", "SYWBHCLEXJAURCMJYI", "MILEY", "CYRUS","SIZMYMPR","CUIYBELS","MPBIZS"));

        allQuestions.add(new Questions("Who was an American professional boxer and activist ?", "ABHIPILEAIAUDMMSMA", "MUHAMMAD", "ALI","AAMILANMN","MZDOVSHUS","SNVZNSO"));

        allQuestions.add(new Questions("which inventor gave world the first practical electric light bulb ?\n He suffered from hearing impairment since young and became deaf as an adult.", "LIPMSTSOKXOMDNHAEA", "THOMAS", "EDISON","IESTESPND","DFMADMHOO","MDPFED"));

        allQuestions.add(new Questions("Who was the sixteenth President of the United States & the first US President to be assassinated ?", "IANRORBHLFUCMLANAK", "ABRAHAM", "LINCOLN","BLMLCANRV","AJRNTAOHI","TRJV"));

        allQuestions.add(new Questions("Who was one of the most iconic martial arts instructors who also played lead role in the film \"Enter the Dragon\" (1973) ?", "FCSLQRUVBESPLJXECE", "BRUCE", "LEE","CUBEHRK","ELERMSW","SWHKMR"));

        allQuestions.add(new Questions("Who is Known as the \"Oracle of Omaha ?\nHe is one of the most successful investors of all time.\n His Berkshire Hathaway owns more than 60 companies, including Geico, Duracell and Dairy Queen.", "FRTTNFENBUWERWEFAT", "WARREN", "BUFFETT","IWEARRTEB","FNTFEVDUD","VDIED"));

        allQuestions.add(new Questions("\"Toxic\" is a song recorded by which American singer for her fourth studio album \"In the Zone\" (2003) ?", "NSYIFEAERBRZTPBESA", "BRITNEY", "SPEARS","UIWYSEBPE","NSAADRBRT","DBUAW"));

        allQuestions.add(new Questions("Who was a Serbian-American inventor, electrical engineer, mechanical engineer, physicist, and futurist who is best known for his contributions to the design of the modern alternating current electricity supply system?", "SLEKLGIAINOIRSAJTU", "NIKOLA", "TESLA","LDELFGTSN","KTSIBHAOA","TFBDHSG"));

        allQuestions.add(new Questions("A.P.J. _____ _____, the 11th President of India, is also popularly known as the Missile Man", "LSKVLMDWABUHEASOGA", "ABDUL", "KALAM","KALANLBJ","CULDMLNA","JLCNLN"));

        allQuestions.add(new Questions("Who is well-known for being a brutally honest judge on the reality television shows, ‘Pop Idol’, ‘American Idol’ and ‘The X factor’ ?", "CMOEGGNMLLOWISOENP", "SIMON", "COWELL","OSNLWOCLT","FELIPNMIN","FILPTNN"));

        allQuestions.add(new Questions("\"_____ _____ Moretz\"(full name) is an American actress most famous for her role of Mia in the movie ‘If I Stay’.", "GREOCEEZCXHXATBGLG", "Chloe", "Grace","RLCECHAO","BEOEGYCS","YBSOCE"));

        allQuestions.add(new Questions("\"Like a Virgin\" & \"MDNA\" are the albums of which American artist ?", "MFXSODFAGNAMUDMNCA", "MADONNA", "","MNCJAJA","NVEOGND","NVJEJGC"));

        allQuestions.add(new Questions("Who is a famous Canadian-American actor, comedian known for his exceptional performance in ‘The Truman Show’ ?", "YXBJICRAOLRJTQCBME", "JIM", "CARREY","NROMYYCU","EPMMRIJA","MPUOMNY"));

        allQuestions.add(new Questions("It is said that the falling of an apple from a tree inspired a great scientist to discover the force behind the action which eventually led to the discovery of gravitational force, Name him.", "WNOWENONNASJJAIWCT", "ISAAC", "NEWTON","TTENNIIOY","SCARMLWOA","MTLIRYO"));

        allQuestions.add(new Questions("Who is one of the most important American political leaders of modern times and served as the 42nd President of the USA ?", "CLLSNACLIBDWINOWTB", "BILL", "CLINTON","ROCWIANNL","TXVLMBCIL","VXRACWM"));

        allQuestions.add(new Questions("What is the name of the actress who played Hermione Granger in the Harry Potter series of films ?", "RMNFAOOSMTTAEMNWOJ", "EMMA", "WATSON","AAOOEAFS","WHAMMATN","OAFAHA"));

        allQuestions.add(new Questions("His novel, ‘The Adventures of Huckleberry Finn’, a direct sequel to ‘The Adventures of Tom Sawyer’, is commonly named among the Great American Novels, Name him.", "IIEOHRJWANDAKMTYAM", "MARK", "TWAIN","CNAKMIAC","KWTFLHTR","FTLHCKC"));

        allQuestions.add(new Questions("Who is often referred to as ‘People’s Princess’ & also known by nicknames, ‘Princess Di’, and ‘Lady of Hearts’ ?", "JPIARFANZSSENXSDCI", "PRINCESS", "DIANA","AIIPNRSJO","HVESDCNJA","VJOJH"));

        allQuestions.add(new Questions("\"_______ SHAKESPEARE\"(full name) is often referred to as England’s national poet and ‘Bard of Avon’.", "SRKLAWHAPIESEAEIML", "William", "","EWNKLBA","ILLPMIV","BPVENKL"));

        allQuestions.add(new Questions("An American Founding Father who was the principal author of the Declaration of Independence, Name him.", "OEFTNFAUSHJMROEHUS", "THOMAS", "JEFFERSON","FTSZLRNHA","EZOEJMFSO","ZZL"));

        allQuestions.add(new Questions("Who co-founded search engine Google with Sergey Brin while doing Ph.D. studies at Stanford University, in California ?", "UREGADPROAKZLYGONU", "LARRY", "PAGE","LAGDRBAI","RIKPFTEY","BIKTFDI"));

        allQuestions.add(new Questions("Who is known for his pro-environment inventions like the electricity powered sports car ‘Tesla Roadster’ ?", "UGOKPHSFGNKMZCJUEL", "ELON", "MUSK","LZMLVEN","UOHSKIH","HVLIHZ"));

        allQuestions.add(new Questions("Who is a Business tycoon belonging to China known for his e-commerce business venture ‘Alibaba’.", "AZKKNMUACAVMJFQYGW", "JACK", "MA","ADBAJAC","CKFOHME","OEABCHDF"));

        allQuestions.add(new Questions("A mastermind was a renowned Greek mathematician, known as the ‘Father of Geometry’, Name him", "ZLXPVOEEOKIUCIDVOR", "EUCLID", "","BLZCEQC","DUNCAII","CNBQCZIA"));

        allQuestions.add(new Questions("As She is left handed, guns had to be custom made for this actress so that she could load them easily in the movie, ‘Lara Croft: Tomb Raider’, Name her.", "MEJMAOZLNEAINILJGH", "ANGELINA", "JOLIE","JRLBKAENL","ANEOAVGII","RBKVA"));

        allQuestions.add(new Questions("\"_____ _____ Jr\" is famous for his role of iron man.", "OQWOYTNEROBEDRRTPX", "ROBERT", "DOWNEY","EORNEBYVM","OTDBGRRWR","RBRGVM"));

        allQuestions.add(new Questions("Greatest painters of the 20th century was twice conferred with the International Lenin Peace Prize, first in 1950 and next in 1961, Name him.", "DOPJBAOICAPCSCLGSD", "PABLO", "PICASSO","PXUOEIQPO","CZBLAASOS","UXEOQZ"));

        allQuestions.add(new Questions("Who played an important role in India’s struggle for freedom & also known as father of nation (India) ?", "UHNRMSMDAGATHMAILA", "MAHATMA", "GANDHI","FGQIHGTAA","AABMIHNMD","IBFQG"));

        allQuestions.add(new Questions("\"Bailando\" (English: \"Dancing\") is a song by which Spanish singer ?", "EGIEURLNOSAEEIIHQS", "Enrique", "Iglesias","SMERILQEI","SGAEGNUIO","OGM"));

        //personality 2 #
        allQuestions.add(new Questions("\"Hips Don't Lie\" is a song by which Colombian singer and songwriter ? \n she is highly popular award winning Columbian pop singer and dancer.", "KFYDSJAAPIWHNMRBUR", "SHAKIRA", "","YRKVIAH","SUWAUIY","WIYUVUY"));

        allQuestions.add(new Questions("First President of the United states, who led the country to victory in the American Revolutionary War, Name him", "AIOWTERSZGNOEIHNGG", "GEORGE", "WASHINGTON","GAWOOETEH","NHSJRIGNG","JH"));

        allQuestions.add(new Questions("______ also known by his ring name 'The Rock', is an American actor, producer, singer, and professional wrestler.", "LONMVAZWDOHEFNSJNY", "DWAYNE", "JOHNSON","DNWJNEZVA","SKOOYNHIG","IKZVG"));

        allQuestions.add(new Questions("Who was awarded the Mark Twain Prize for American Humor (2015) by the John F. Kennedy Center ?", "DPIDEEPHUFMPYDTRRP", "EDDIE", "MURPHY","DDUDIHRED","MYMEYPPKE","YDDKPME"));

        allQuestions.add(new Questions("“Eureka” was the word that he uttered in excitement, now forms the state motto of California. he was one of the greatest scientists & mathematicians, Name him", "MCIEECIHMTSPXDARUO", "ARCHIMEDES", "","APRCMUIH","ODSGEETV","OGPTVU"));

        allQuestions.add(new Questions("Guess: A professional German retired car racer who has won the ‘Formula One’ championship on seven occasions.", "SMMUALRAEHMHECHICC", "MICHAEL", "SCHUMACHER","ALHUCERKE","CCSMHIAHM","K"));

        allQuestions.add(new Questions("In 2015, Who became the second-youngest person to become Prime Minister of Canada ?", "ETSDZRRTSUNUAHUIUJ", "JUSTIN", "TRUDEAU","LIQUUUREO","BJTTNSIAD","OIQBL"));

        allQuestions.add(new Questions("Who is first daughter of the president Donald Trump and his first wife former model Ivana Trump ?", "IPKRSAWTUVOXINMAPR", "Ivanka", "Trump","APMONTYTO","VIKYGNAUR","YNOOGYT"));

        allQuestions.add(new Questions("Which talented talk show host is now considered to be the wealthiest African-American woman in the United States ?", "ENHOYRRPRBZIFAWPTP", "OPRAH", "WINFREY","WRHONIONY","ITHFRAPEE","NHOTEI"));

        allQuestions.add(new Questions("The famous selfie clicked at the ‘86th Academy Awards’ which include her along with eleven other celebrities has created a record of being the most retweeted image ever, Name her.", "GENEERLENLVYBJEDSE", "ELLEN", "DEGENERES","NLESDYHLE","RNFGEEEBE","BFHY"));

        allQuestions.add(new Questions("Who is an American singer, rapper, songwriter, businessman, record producer and actor of Senegalese descent ?", "WGPKWBNLTQVMJOORDA", "AKON", "","ONIVZY","KMKDQA","VYKMQDZI"));

        allQuestions.add(new Questions("_______ was a Scottish biologist and pharmacologist who discovered enzyme lysozyme and antibiotic penicillin.", "UNLRFNAEEMALXEIDTG", "ALEXANDER", "FLEMING","AXELDQIAM","EOGRNNLFE","QO"));

        allQuestions.add(new Questions("Her portrayal of Rachel Green from American sitcom \"Friends\" made her a fashion icon and the hairstyle she wore began to be called ‘the Rachel’.Name her.", "TNLIINNNRJOEBMSFEA", "JENNIFER", "ANISTON","SJNUNTIEO","FELANORIN","ULO"));

        allQuestions.add(new Questions("\"Aubrey _______ Graham\" is a Canadian rapper, singer, songwriter, record producer, and actor.\nHis songs include \"Hotline Bling\",\"One Dance\",\"\"Over\" etc.", "GZFZBRZGBWDROAKKED", "DRAKE", "","RDIKNE","OXPNUA","NOIUPXN"));

        allQuestions.add(new Questions("______ is an American businessman who co-founded Twitter.", "JPASFBARQDKOCREDYS\n", "JACK", "DORSEY","KHOQECHD","RUKYJASR","QKUHHR"));

        allQuestions.add(new Questions("Which sportsmen was honored as one of the 50 Greatest Players in NBA History in 1996 ?", "SYNGNXVMCOBJIHOAZV", "MAGIC", "JOHNSON","JMNCMHGAE","OEJODSICN","MECEJD"));

        allQuestions.add(new Questions("Who is the 266th Pope of the Roman Catholic Church ?", "VAIJPSERCRNNPBPIOF", "POPE", "FRANCIS","KCPEFRWJS","AFESIPONQ","WSJKQEF"));

        allQuestions.add(new Questions("Who was an Italian explorer and navigator after whom the Americas were named ?", "AUYIMGOREEPSCCVELI", "AMERIGO", "VESPUCCI","GPMCWVCEA","MIURSIOEZ","WMZ"));

        allQuestions.add(new Questions("Who is current CEO of Google Inc ?\nHe was also one of the top contenders for the post of CEO at Microsoft, which ultimately went to Satya Nadella.", "IHAUSRPXNASXDCTIHI", "SUNDAR", "PICHAI","TIPNRSACU","DCZBYHIAZ","YCTZZB"));

        allQuestions.add(new Questions("A Jewish victim of the Holocaust, was the author of ‘The Diary of a Young Girl’, Name her", "TNANYBAAEFKHLKNRSA", "ANNE", "FRANK","CFREAYNN","WFKNBQPA","YCWPQFB"));

        allQuestions.add(new Questions("Which famous golfer is of mixed African American, Native American, Chinese, Thai and Dutch ancestry ?", "QNERDDFRSIZOGOWTOI", "TIGER", "WOODS","OWQDHEST","GPOHIHOR","HHQPHO"));

        allQuestions.add(new Questions("Who's album ‘Blonde on Blonde’ was one of his first major hits. It peaked at No. 9 on the Billboard 200 chart in the US and No. 3 in the UK ?", "BNCNLMKCADNBOPQYLH", "BOB", "DYLAN","NOGBLCJ","YWZBADB","WGCJBZ"));

        allQuestions.add(new Questions("Who was named an ambassador for the 2012 World Humanitarian Day campaign for which she donated her song ‘I Was Here’ and its music video ?", "TWBALYPOUNNEUPSLEC", "BEYONCE", "","TWCYQZE","NBOCERZ","WCZTQZR"));

        allQuestions.add(new Questions("Who won the British Supporting Actress of the Year at the London Critics Circle Film Awards for her role in ‘The Last Days of Disco’ in the year 1999 ?", "COOTBSIAENEEKLITAK", "KATE", "BECKINSALE","TICKEPBAS","ESKBELNCA","CBSP"));

        allQuestions.add(new Questions("Who is a popular world pop icon, known for songs like ‘Poker Face’ & 'Bad Romance' ?", "YKPGAEANGLNZURBLDA\n", "LADY", "GAGA","AABDGEG","ASGYCCL","SEGCCB"));

        allQuestions.add(new Questions("_____ is a Hollywood star best known for his performances in movies like the ‘Die Hard’ series and ‘Pulp Fiction’.", "UEBSWYRLIXPIMGLAKC", "BRUCE", "WILLIS","CDWLYRBPL","SISJWRUIE",""));

        allQuestions.add(new Questions("Famous American actor, known for his movies, ‘Ocean’s Eleven’, ‘The Curious Case of Benjamin Button’, and ‘World War Z’, Name the actor.", "PPUDRNTYTAIEVTCBKC", "BRAD", "PITT","DGAZRRL","BTDITPW","WGRZLD"));

        allQuestions.add(new Questions("Who won his second ‘Oscar’ in 2012 as a producer of ‘Argo’ ?", "OGGOPEERBJYCLEOSFN", "GEORGE", "CLOONEY","PLGOEOZRC","GUENEYEOR","PREUZ"));

        allQuestions.add(new Questions("The term rock 'n' roll was coined by whom ?", "YIMAXAFDEALCHRNAET", "Alan", "Freed","ARMASNEF","EHADDXLR","RSDXAMH"));

        allQuestions.add(new Questions("Who is the founder and current CEO of Amazon.com ?", "OOEJQBFBJDKZBSFOIE\n", "JEFF", "BEZOS","BAFIBOES","EKJFEOZL","EKALIBO"));

        allQuestions.add(new Questions("Which Hollywood actor loves to collect typewriters and has 80 of them in his collection ?", "SKGNAOGBYLPKWHTMWJ", "TOM", "HANKS","STYQDNH","OQCIMAK","IDCQQY"));

        allQuestions.add(new Questions("Who was an American stand-up comedian and actor. Starting as a stand-up comedian in San Francisco and Los Angeles in the mid-1970s ?", "WMOSPAIXDNBILZOILR", "ROBIN", "WILLIAMS","ORWOMTIAI","LBLISOVVN","VVTOO"));

        allQuestions.add(new Questions("\"Rabindranath ______\"(full name) Great Bengali poet was an admirer of Gandhi and was the one who gave him the name “Mahatma”, Name him.", "AAIRGNARHDOTREABTN", "TAGORE", "","TRNQLOE","JGAYYLR","NLYLRQYJ"));

        allQuestions.add(new Questions("\"Alexander ______ ______\"(full name) was a Scottish-American scientist and inventor, referred to as ‘Father of the Telephone’.", "UMBAXTIERLJAJPNGHL", "GRAHAM", "BELL","ALQGMFRM","ERHLSABZ","SFZQMR"));

        allQuestions.add(new Questions("______ is the wife of U.S. President Barack Obama and the first African-American as First Lady.", "EBOMMOHBUACLAIELEC", "MICHELLE", "OBAMA","BLCFMEAML","LIEOLMAHW","FMLLW"));

        allQuestions.add(new Questions("The name \"_____\" is a shortened version of his real name ‘Vincent’. He received the nickname \"_______\" from his friends, who said he ran off diesel fuel, referring to his non-stop energy.", "LVOEEDIZNREQIISMTY", "VIN", "DIESEL","IWDNLEOQ","EVSMIDNZ","OWDMQNZ"));

        allQuestions.add(new Questions("His main discoveries include the principles underlying electromagnetic induction, diamagnetism and electrolysis, Name him.", "VLYHRAEFAMACADUAID", "MICHAEL", "FARADAY","MAGRERIDR","YFALHCAAQ","GQRR"));

        allQuestions.add(new Questions("Famous personality & the founder of ‘Marxism’ often swallowed opium to overcome the pain he endured due to his liver problems, Name him.", "LRZHHKXSWCARZALDUM", "KARL", "MARX","NDLTXAR","ARJXQMK","QNDJXT"));

        allQuestions.add(new Questions("Nicknamed JFK and Jack, John F _____ served as the 35th President of the United States.", "HHKBIEYFAHENPDTSNP", "KENNEDY", "","EKADECY","ZNNYIZE","ZIAZYEC"));

        allQuestions.add(new Questions("The heart and brain of this famous writer have been removed from his body. His heart is in the ‘Bibliotheque Nationale’ in Paris and his brain has since been lost after being auctioned off, Name him.", "EEINLTOAJQVARQYGDT", "VOLTAIRE", "","FXSOTLI","VOEERAS","ESFSXO"));

        allQuestions.add(new Questions("Who is regarded as the father of modern computers ?", "BXCBAGHBLSAREAEUWV", "CHARLES", "BABBAGE","WRCBEHBSL","AGABBHAZE","ZHBW"));

        allQuestions.add(new Questions("Who rose to stardom with roles in The Mask (1994), My Best Friend's Wedding (1997) and There's Something About Mary (1998), and is also known for voicing the character of Princess Fiona in the Shrek series (2001–10) ?", "LPCVZDARDNMIEEALON", "CAMERON", "DIAZ","ODCEIQMKA","ZIRJAIDJN","JQIDKIJ"));

        allQuestions.add(new Questions("Starring roles as Han Solo in the Star Wars film series and as the title character of the Indiana Jones film series has gained him worldwide fame, Name him", "SBXNKHRDIAFRGROWOS", "HARRISON", "FORD","FROSTRORO","FLNWIDHAR","TFORWL"));

        allQuestions.add(new Questions("His start in stand-up comedy began at the 'hungry i' in San Francisco and was followed by his landing a starring role in the 1960s television show I Spy, Name him", "SBUBHBLOCIXWYQDGLM", "BILL", "COSBY","FLBLTBOM","YCHCKSIY","HTFMKYC"));

        allQuestions.add(new Questions("One of Ancient Rome's most famous individuals, He was a statesman who changed the face of Rome, Name this genius.", "UEOASDLYSCBUWJFIRA", "JULIUS", "CAESAR","ABLSLEIRU","IJUCSAECM","MBCLEI"));

        allQuestions.add(new Questions("Who gained worldwide recognition for her ten-season run as Phoebe Buffay on the television sitcom \"Friends\" ?", "UYIFLBDADRSHWRVKJO", "LISA", "KUDROW","DUWFUKFI","ODSBARLL","FDBFLU"));

        allQuestions.add(new Questions("One of the founding fathers of the USA, _______ was a multi-talented personality. He was a scientist, inventor, author, musician and a statesman.", "JEKIBNNGIANRAFLNMS", "BENJAMIN", "FRANKLIN","LBRMJHFNF","INENKNIAA","FH"));

        allQuestions.add(new Questions("Who was a singer & actor, known as ‘The king of Rock and Roll’ ?", "REUEVEKLNISDXFYSLP", "ELVIS", "PRESLEY","SHREVLEGT","PUYLIQLSE",""));

        allQuestions.add(new Questions("Who's roles in films like ‘Punch-Drunk Love’ and ‘The Wedding Singer’ are well known ?", "LEZNDSAYNBADRAFARM", "ADAM", "SANDLER","NMNAUXDER","SDLAZCAQN","NNZXQUC"));

        allQuestions.add(new Questions("An Italian physicist who made major contributions to the development of nuclear energy ?", "JINEFZVHIGOERMRRZC\n", "ENRICO", "FLEMING","YLNEHICRT","NEIMGFOLN","HYTLN"));

        allQuestions.add(new Questions("Which actress is best known for her role in the film ‘Breakfast at Tiffany’s’ as Holly Golightly ?", "DBSHEQEPUNRRAPYDUU", "AUDREY", "HEPBURN","RUEENBFOH","UDKSAEPRY","SOKEF"));

        allQuestions.add(new Questions("Which famous mathematician and astronomer was the first to discover that the earth revolves around the sun and not the other way round ?", "UOSPUNEINOSCCLRCIA", "Nicolaus", "Copernicus","NCOSICPUO","LIRNCESUA",""));

        allQuestions.add(new Questions("_______, Prince of Wales is the eldest child and heir apparent of Queen Elizabeth II.", "IHTXRAHTXIECIUSLKQ", "CHARLES", "","BLTAHPU","CESRQIF","TPIUBFQ"));

        allQuestions.add(new Questions("Which activist is the youngest ever recipient of the Nobel Prize & the only Pakistani winner of the Nobel Peace Prize ?", "AZZMDFAOISAAUAYLJL", "MALALA", "YOUSAFZAI","ZALWMIAAQ","YSOLFABUA","QBW"));

        allQuestions.add(new Questions("In 2009, _____ and Beyoncé were ranked as Hollywood’s top-earning couple by Time Magazine.", "GJJLYVTRZEBALGJSAU", "JAY", "Z","AGNHRS","ZJJEFY","HRNEJSFG"));

        allQuestions.add(new Questions("Which famous actress and singer-songwriter has her own clothing line called, ‘Wet Seal’ ?", "JASCIONPEMRSSZXILS", "JESSICA", "SIMPSON","SSPINCEMP","APEISSQOJ","PEPQ"));

        allQuestions.add(new Questions("Which great ex-President of US was awarded the Nobel Peace Prize 1919, in recognition of his efforts in the formation of the League of Nations ?", "WOWPIXWUNROSLORDOW", "WOODROW", "WILSON","RDIQSOODO","WNLSWUXWO","DQSUX"));

        allQuestions.add(new Questions("Who formed a successful partnership with Matthew Boulton to build steam engines ?", "EMNYBJWSLCRTAETLEA", "James", "Watt","USTWMEDA","TJWHDASZ","ZHWDSDU"));

        allQuestions.add(new Questions("Which explorer's last words were 'I am just going outside, and may be some time' ?", "OARDSNCAEHEETUULAG", "Laurence", "Oates","NETSRLLEW","SOAUTEACN","LNTSW"));

        allQuestions.add(new Questions("The political theory derived from the teachings of who's Marxist-Leninst leader of China is called Maoism ?", "OZHEOGMISHAYRXWDON", "MAO", "ZEDONG","VGEYCGNA","VNOMZDOH","VCVHGYN"));

        //personality hard

        allQuestions.add(new Questions("One of the most prominent female politicians of the United States & was the 67th United States Secretary of State, Name her.", "LTEIOLNRYPLOHNCLAI", "HILLARY", "CLINTON","NAYTROIBL","SCLLIHNLH","SHLB"));

        allQuestions.add(new Questions("Who is the co-founder and promoter of Wikipedia, the online non-profit encyclopedia ?", "PMALEMQWHKSBIMMJUY", "JIMMY", "WALES","KIBKPUMY","JAPLESMW","PPKKBU"));

        allQuestions.add(new Questions("Who was the first to establish the concept that all species descended from common ancestors and that the branching pattern of evolution resulted from a process which he termed natural selection ?", "NEDHRICSHWLDADFRAD", "CHARLES", "DARWIN","YGWLITCNA","DRARHSADE","AYDGT"));

        allQuestions.add(new Questions("Who was called the Godfather of Soul ?", "RNAWHDWBMKMMOEASJB", "James", "brown","EWBSURAU","OMSANAWJ","WASUUA"));

        allQuestions.add(new Questions("An American politician and soldier who served as the first President of the United States from 1789 to 1797.\nName him.", "WHNGONGONEEGAISRIT", "GEORGE", "WASHINGTON","TREGOIWGE","GNLOSNHEA","EL"));

        allQuestions.add(new Questions("Which professional tennis player is popularly referred to as Fed Express or FedEx. People even call him Swiss Maestro or simply Maestro for his exceptional skills at the game ?", "KFEEEGRRRMNEFDGORG", "ROGER", "FEDERER","GFRDOQEMM","REESBERLR","LMBQMS"));

        allQuestions.add(new Questions("As the current CEO of Microsoft, he is one of the most powerful Indian-born tech executives in the world. Name him.", "YELVEMPNLADADSATAF", "SATYA", "NADELLA","LAAYJEYVL","AATSVBIDN","YVIJVB"));

        allQuestions.add(new Questions("Who is most known for his work in the study of black holes. With the theoretical prediction that black holes emit radiation, a theory called ‘Hawking radiation’ ?", "FWIARKGAHNCPSNEHTT", "STEPHAN", "HAWKING","HHNETNNWI","KKAPAGBES","BKEN"));

        allQuestions.add(new Questions("In 1999, Scottish actor ________ received a Kennedy Center Honor for Lifetime Achievement and was knighted by the Queen Elizabeth II in July 2000.", "PNNHICNADRSAOYEECD", "SEAN", "CONNERY","CNRNMONSA","GEOYLQDES","GSQODLM"));

        allQuestions.add(new Questions("Before serving as the 33rd Governor of California and the 40th President of the United States, which iconic politician was a radio sports announcer and an actor ?", "RNOADEREGNAALUNIDK", "RONALD", "REAGAN","OQDANEGRN","LARAZPACP","QPAPZC"));

        allQuestions.add(new Questions("Who is the software engineer who created the Linux kernel operating system ?", "LSAALOSLDUGCIRNTVL", "LINUS", "TORVALDS","SSLFUNAOH","IRDTLVICS","SICFH"));

        allQuestions.add(new Questions("Who is widely regarded as the father of India's space programme ?", "AAIAIMABXHIKSTRVRM", "Vikram", "Sarabhai","IFAARVBWA","HAKRMIABS","WBFA"));

        allQuestions.add(new Questions("An American model, actress, and television personality. \"______ ______ Smith\" first gained popularity in Playboy, winning the title of 1993 Playmate of the Year.", "ZCEYLJANAOVKNYISNR", "ANNA", "NICOLE","CNNICKVO","NLOQAEAV","VKCOQV"));

        allQuestions.add(new Questions("Who is an Academy Award winning actor known for his work in movies like ‘Street Smart’, ‘Driving Miss Daisy’ and ‘Million Dollar Baby’ ?", "AYREZNRFGARMOMOSEN", "MORGAN", "FREEMAN","ENMFNORRA","GAIVSGEJM","GJIVS"));

        allQuestions.add(new Questions("Who was the film star who married Prince Rainier III of Monaco ?", "LLAGKYQSERCELLTCRR", "Grace", "Kelly","YAZSGEKR","ACGTELLE","GZSATE"));

        allQuestions.add(new Questions("An illustrious musician, songwriter, singer, actor and the founding member of ‘The Rolling Stones’, Name him.", "AOMEJRHQCGUIVXVGKS", "MICK", "JAGGER","XMRGICGE","KEJYPALN","XPENLY"));

        allQuestions.add(new Questions("Who is the first woman to be awarded with the prestigious Nobel Prize and the only to win it in two field and multiple sciences. She is responsible for coining the term radioactivity ?", "HCRIWUYEVRAIDBEIMB", "MARIE", "CURIE","MFTYZEIR","ORUUECAI","ZFOTYU"));

        allQuestions.add(new Questions("In 2017, as the Policing and Crime Act 2017 was enacted in UK, Wilde was officially pardoned for his offence as homosexuality is no longer a crime in England, Name him", "DVPULCEIIAOSRZWFAV", "OSCAR", "WILDE","SACAZLTE","WRWGTDOI","TAWGZT"));

        allQuestions.add(new Questions("Who was a famous English chemist and pioneer x-ray crystallographer who unravelled the structure of DNA and RNA ?", "AANNFNKLSRLIIOIDRP", "ROSALIND", "FRANKLIN","INKFLOWNR","LTAIDRANS","WT"));

        allQuestions.add(new Questions("\"John Joseph ______\" is an American actor and filmmaker, who has performed for over 60 years.", "NILACNOCRSJONDOKHV", "JACK", "NICHOLSON","ENAKHVONS","CIDCJONLE","EVDNE"));

        allQuestions.add(new Questions("Who is the founder of the Ferrari automobile marquee ?", "RETNMFROOIYRZERMAD", "ENZO", "FERRARI","RYETORNAZ","RIEEAFRQR","ATQERRY"));

        allQuestions.add(new Questions("In partnership with the Hawai'i Community Foundation and the GRAMMY Foundation, Who has established a GRAMMY Camp Scholarship Fund, in order to provide financial assistance to next generation of music makers ?", "OHOEHNAMOMSBRLMDUR", "BRUNO", "MARS","MYJUVBBN","MAMSRROL","JVMYBML"));

        allQuestions.add(new Questions("Who was an American attorney, planter and politician who became known as an orator during the movement for independence in Virginia ?", "AHCOKYVINCREERHPTR", "PATRICK", "HENRY","IFARRHLKC","TREPWNAEY","RWLAFE"));

        allQuestions.add(new Questions("Who is an American business magnate, investor and philanthropist. He is best known as the co-founder of Microsoft, alongside Bill Gates ?", "LEDXALLLVNNAUDPUEG", "PAUL", "ALLEN","ELVLUNOQ","XQVOLAAP","VOXVOQQ"));

        allQuestions.add(new Questions("Which lady astronaut formerly held the records for total spacewalks by a woman and most spacewalk time for a woman ?", "MTZWALNFULIIIISKSA", "SUNITA", "WILLIAMS","LLSMWJIPC","UTIIASDAN","CPJD"));

        allQuestions.add(new Questions("Who is an Indian-born American business executive currently serving as the Chairperson and Chief Executive Officer of PepsiCo ?", "CIYUMOWQKIDROQANFN", "INDRA", "NOOYI","NNOBRALE","OIYKEJID","EKELJB"));

        allQuestions.add(new Questions("Who is an American information technology executive, currently serving as the CEO of Yahoo ?\nA position she has held since July 2012.", "BAAERSAYMHINIREMGS", "MARISSA", "MAYER","MAPAREKCA","MYGASISRY","GKAYCP"));

        allQuestions.add(new Questions("This British born actress used to keep her Oscar statuettes in her bathroom but had to move them to make room for her daughter’s artwork. Name her.", "EUOAOHMOXMYMTFNPBS", "EMMA", "THOMPSON","ETNAMYGMR","POSNDUMOH","NYGDRU"));

        allQuestions.add(new Questions("Scottish economist, philosopher, and author. He was a moral philosopher, a pioneer of political economy, and was a key figure during the Scottish Enlightenment era. Name him.", "FHTIMAACSHVPWPDGRM", "ADAM", "SMITH","VSMDFMRI","SHAATDAT","FSRDTVA"));

        allQuestions.add(new Questions("Who led a government in Italy in the 20s and later became its dictator ?", "MOIDWUSLUEIVGSFUQN", "Mussolini", "","BNSMLXIJ","OUBISSYI","BIBXJYS"));

        allQuestions.add(new Questions("Which Austrian wrote \"The Psychopathology of Everyday Life\" ?", "JDSTUNEDUVDKJGRFIM", "Sigmund", "Freud","SUGSFPEDD","QRJINCMUU","UQJPSC"));

        allQuestions.add(new Questions("A pop musician who laid the foundation for rock and roll music in America. Name him.", "TCGRLMXRTOHQDIAIEL", "LITTLE", "RICHARD","PACCRDLTI","THRDERLDI","DPRCD"));

        allQuestions.add(new Questions("Best known as the host of the award winning news show, CNN’s ‘______ _____ 360’.", "DOOOEMPGAONNREQCSR", "ANDERSON", "COOPER","QPTONNAZS","XCDROREEO","ZQXT"));

        allQuestions.add(new Questions("Jersey No. 12, which _______ held in the Pittsburgh Steelers, has not been reissued to any player, post his retirement.", "RHAHMEWEYDRHSAFRTB", "TERRY", "BRADSHAW","SEURJHADT","RABWKDRUY","JDUKU"));

        allQuestions.add(new Questions("Who is American civil rights activist, Baptist minister, and politician who was also a candidate for the Democratic presidential nomination in 1984 and 1988 ?", "ODZDEAJKCOSESTLSJN", "JESSE", "JACKSON","KNOSSZOJA","JELCSNJEK","OKJLNZ"));

        allQuestions.add(new Questions("Who was awarded the Presidential Medal of Freedom, the highest civilian honor in USA in the year 2002 by George W. Bush ?\n The award was given in recognition to his contribution to the welfare of children.", "EGFXDBNOIEXSGNRRQR", "FRED", "ROGERS","EORRFWEP","TKSVRCGD","VWCTPK"));

        allQuestions.add(new Questions("One of the strongest political leaders of Independent India, she was the first woman to hold the office of the Prime Minister, Name her.", "AZRLGDYIDNIIAIDHNP", "INDIRA", "GANDHI","IADVDNIRN","LGDXRIABH","XDLRVB"));

        allQuestions.add(new Questions("Who is the co-founder and CEO of the American multinational technology and social media company Snap Inc..,which he created (as Snapchat Inc.) ?", "KAKLNEEECGVELSISPK", "EVAN", "SPIEGEL","PIELEINSY","GIVEATJLE","ITIYJEL"));

        allQuestions.add(new Questions("Katheryn Elizabeth Hudson, known professionally as ______, is an American singer and songwriter. After singing in church during her childhood, she pursued a career in gospel music as a teenager.", "OYATFKDUYPPLEQTRRF", "KATY", "PERRY","AEEYKKPD","URTKRYDL","KLDDEKU"));

        allQuestions.add(new Questions("Who was the woman who played the biggest role in instigating the French Revolution ?\nShe was the last queen of France.", "UAIERNETAIFITNEOMT", "MARIE", "ANTOINETTE","TTNEPTEFA","AIIMETNRO","TFP"));

        allQuestions.add(new Questions("Who was a Georgian-Soviet revolutionary, politician and political theorist. He governed the Soviet Union from the mid-1920s until his death in 1953 ?", "SKSLNJPHAUTIFEOJAH", "JOSEPH", "STALIN","JJTHAJHON","OPIOSBSLE","HBOJOJ"));

        allQuestions.add(new Questions("Who was a philosopher, statesman, scientist, jurist, orator, and author who served both as Attorney General and as Lord Chancellor of England ?", "FOASAWKONBODNCRICM", "FRANCIS", "BACON","IPOSAAABR","NFNSNCCCE","CASNEP"));

        allQuestions.add(new Questions("Canadian Prime Minister was awarded a 2nd dan black belt in judo by the Takahashi School of Martial Arts in Ottawa. Name him.", "TUODEARRPEEKRURJDI", "PIERRE", "TRUDEAU","RRTPARURI","UEEELCDQW","RLWCQ"));

        allQuestions.add(new Questions("______ is a computer programmer and author. He created the Perl programming language. Name him", "AERURYJKLARXWHALLW", "LARRY", "WALL","JRKUBLAB","AUWRWYLL","JBUUWKB"));

        allQuestions.add(new Questions("According to The Discovery Channel show ‘Chasing Classic Cars’, it is believed that _______ American stand-up comedian owns the first and last air-cooled Porsche 911s produced.", "JNDLHBEERLEUFIDSRY", "JERRY", "SEINFELD","LRYMTSVFR","KNIEENDEJ","NTMKV"));

        allQuestions.add(new Questions("One of the co-founders of the rock band The Beatles was returning home with his wife on 8 December 1980 when Mark David Chapman shot him in the back four times. He was rushed to the hospital but was pronounced dead on arrival. Name him.", "LJZENERFFONJNOMNHL", "JOHN", "LENNON","ELLNOJHR","EONZNTND","RZTELD"));

        allQuestions.add(new Questions("She was named by the American Film Institute as the greatest female star of Classic Hollywood Cinema in 1999.\nShe was leading lady in Hollywood for more than 60 years.\nShe died on June 29, 2003 (aged 96),Name her.", "RIBANHJHAKRENHPTUE", "KATHARINE", "HEPBURN","TEPRHAHKN","RAIUBNEUI","UI"));

        allQuestions.add(new Questions("Who is best known as the father of the Java programming language ?", "GPTIMLEIJUGOGSDAGN", "JAME", "GOSLING","NOJMXIGNC","AQGESQLWL","QCQXNWL"));

        allQuestions.add(new Questions("Who was a French theologian & pastor who played an important role in the Protestant Reform movement ?", "UNIQRNYOHULJXAHBVC", "JOHN", "CALVIN","BAIMJNOD","CNZLVMHL","LMBMZD"));

        allQuestions.add(new Questions("Who was the thirty-seventh President of the United States and the only President to ever resign from office ?", "NRCRQAIWFRXIOHMTND", "RICHARD", "NIXON","HICRIRORM","UGDEACNNX","RUCEGM"));

        allQuestions.add(new Questions("Who is a French former actress and fashion model who later became an animal rights activist ?", "TERBQTDBTRGAODJIIV", "BRIGITTE", "BARDOT","WRIEBOBYR","PSTDTIGAT","SPWY"));

        allQuestions.add(new Questions("Who was the fifth President of Iraq, serving from 16 July 1979 until 9 April 2003 ?", "UUSHDAZAOEFMFISSND", "SADDAM", "HUSSEIN","NEBDASSUS","IZSADHSJM","JBSSZ"));

        allQuestions.add(new Questions("Guess: A French military and political leader who rose to prominence during the French Revolution.", "AAPPLZNANOTBNOEORE", "NAPOLEON", "BONAPARTE","PNATNLOON","APEARBEZO","Z"));

        allQuestions.add(new Questions("Who was an Italian Dominican theologian hailed as the father of the Thomistic school of theology ?", "YOEAUSATSAIVKQMNHO", "THOMAS", "AQUINAS","SQAASXIOF","VATNHUARM","VFXRA"));

        allQuestions.add(new Questions("In 2007, who's wax statue was installed at the ‘Madame Tussauds’ museum, London, which made him the third Indian actor to earn a spot at this prestigious place ?", "NFAHXHAMKSKXHWHSRU", "SHAHRUKH", "KHAN","KNRFHKHAO","SBFAHVEHU","EVFFBO"));

        allQuestions.add(new Questions("A Russian cosmonaut \"_____ Tereshkova(surname)\" created history when she became the first woman to travel to space.", "HVIEERTNSTKAOVAANL", "VALENTINA", "","BTENBVNA","AAGBLYLI","BBGLYBA"));

        allQuestions.add(new Questions("As a World War II veteran, who was the recipient of numerous prestigious awards including Asiatic-Pacific Campaign Medal, American Campaign Medal, and World War II Victory Medal ?", "VRRDKSOARSDENFGDGL", "GERALD", "FORD","ERXEGPXR","DDAFLJOF","FPXJEX"));

        allQuestions.add(new Questions("Who joined hands with Fidel Castro and played an important and crucial role in the Cuban Revolution. For his revolutionary actions and rebellions nature, he became an iconic cultural hero ?", "CNREVAUWJNHFAGTEVA", "CHE", "GUEVARA","EREAVUCG","SLRNHAZF","ZRNLSF"));

        allQuestions.add(new Questions("______ is the reigning Emperor of Japan. He is the 125th emperor of his line according to Japan's traditional order of succession.", "IJATIKYPOADRMFHHTD", "AKIHITO", "","ICBLTMU","KHAOEIV","ELUMBCV"));

        allQuestions.add(new Questions("Who was the Prime Minister of the United Kingdom from 1940 to 1945 and again from 1951 to 1955 ?", "LHXWUQTSIHNILCCNOR", "WINSTON", "CHURCHILL","SWLRCUCNI","IOLTKWHHN","KW"));


       //Sports easy
        allQuestions.add(new Questions("He was honoured with the European Golden Shoe thrice in 2010, 2011 and 2012. He won the FIFA Club World Cup Golden Ball in 2009 and 2011. He was tagged as the European Golden Boy in the year 2005. Name this football legend.", "LILELCSDOMENESUIGI", "Lionel", "MESSI","IJSTNJONE","MLBZESILE","JBETNJZ"));

        allQuestions.add(new Questions("How many ring are there in Olympic flag (in words) ?", "ERLUFHZOEURAFBTEIV", "FIVE", "","ZIEVLZ","BBZDYF","ZLZYZBBD"));

        allQuestions.add(new Questions("Famous professional wrestler who has catchphrase \"You can't see me\". Name him.", "BNHCGJPUANYOMEJYJI", "JOHN", "CENA","JWAEHON","SICPNZE","EWIZPS"));

        allQuestions.add(new Questions("How many soccer players should be on the field at the same time (in words)?", "LYEWTOQSNTMZERHWTT", "TWENTY", "TWO","TTDAETZJ","MWWGQONY","AJZGMDQ"));

        allQuestions.add(new Questions("_____ is the most successful swimmer at the Olympic Games who created numerous world records & the only Olympian to win 8 gold medals in a single Olympic Games (2008 Beijing Olympics).", "IHCBEEANMLLPOPHMSY", "MICHAEL", "PHELPS","ECLRSEIMH","PPHASOLGD","ODSRG"));

        allQuestions.add(new Questions("2010 FIFA World Cup tournament was held in which country?", "XWFQRSOUTASAEDHQIC", "SOUTH", "AFRICA","MTJHIOUAY","AVYOCFSRR","JRMYYVO"));

        allQuestions.add(new Questions("World's most ancient game is ?", "RFCBTOSWNGCIGLYELP", "Wrestling", "","RNTSWNTS","QUEIYLIG","NYQISTU"));

        allQuestions.add(new Questions("How many holes are there in a full round of golf (in words) ?", "ZGNXHAEEIOMTENOCGD", "EIGHTEEN", "","FNAEEEO","HEHITHG","FHOEHA"));

        allQuestions.add(new Questions("What is the national sport of England ?", "HAZKZRTICODNFLRKEC", "CRICKET", "","RDCETKZ","GZIUCTC","TCGDZUZ"));

        allQuestions.add(new Questions("Who won Ballon d'Or 2007 ?", "KJBKKKJNIRGOKTAYAO", "Kaka", "","ZLAMKK","AOKUSE","EMZKSLUO"));

        allQuestions.add(new Questions("What city of Asia hosted the summer Olympics in 2008 ?", "EXICNGJWFCPYBHIGGB", "BEIJING", "","IKBEJEC","AZNIVAG","VZCEAAK"));

        allQuestions.add(new Questions("The Kangaroo Hoppet is a long distance cross-country skiing race that is held in which country ?", "AAPTIRSKUAXLRGTXWS", "AUSTRALIA", "","NURAKISA","TPYLARBU","BKPYNRU"));

        allQuestions.add(new Questions("A shuttlecock is used in what sport ?", "NPWNOBAXTDSMMYKDQI", "BADMINTON", "","TBDIKAHN","GUIZNMOU","HUUIGKZ"));

        allQuestions.add(new Questions("In cricket, a _______ (or wrong 'un) is a type of delivery bowled by a right-arm leg spin bowler.", "BWGJVOGZLBCETKEYQO", "GOOGLY", "","OLGSGTN","UVOOOYQ","ONSVTUOQ"));

        allQuestions.add(new Questions("A kabaddi team usually has how many players (in worlds) ?", "STNHGGEMNGEEEITVEHR", "SEVEN", "","NSEDJR","PEMZVP","JDRPPMZ"));

        allQuestions.add(new Questions("\"Queensberry Rules\" is the name given to the rule in which sports ?", "IBULIJXAMNGPDDEEOK", "BOXING", "","GOCRBOI","WXNPZBI","OIZRCBWP"));

        allQuestions.add(new Questions("Bull Fighting is the national game of which country ?", "NKPWAEZXKGBCSHIXCU", "SPAIN", "","AFSFIN","PQNYJB","BNFFJQY"));

        allQuestions.add(new Questions("What sport use the term 'home run' long before baseball ?", "CRTKFHOECVLWICCLEU", "CRICKET", "","CBJICTE","NUKRDIT","BDUJNIT"));

        allQuestions.add(new Questions("In a standard game of chess, each of the two players begins a game with how many pieces (Iin words)?", "IPSRNXTFBOIPASEERT", "SIXTEEN", "","HIEMNSE","SETZTLX","SHLEZTM"));

        allQuestions.add(new Questions("In sport acronym MVP stands for \"Most _____ _____.\"", "YEAHBVUALVRAEGPLNL", "VALUABLE", "PLAYER","YLLRAYLET","AAEBUVPXL","YTLX"));

        allQuestions.add(new Questions("A portuguese football player was awarded the Ballon D’Or in 2008, when he was a Manchester United player.Name him", "LITONOCRURYDANAISO", "CRISTIANO", "RONALDO","STRCDOORI","OTOIANALN","OT"));

        allQuestions.add(new Questions("Which country does Chris Gayle(cricketer) played for ?", "MEKZVEETWWILZNISDS", "WEST", "INDIES","NISDQEIL","INWESWET","WLQINE"));

        allQuestions.add(new Questions("Which Argentine player moved from Manchester United to Manchester City in 2009 ?", "BALCTESOEENMRVKTRZ", "CARLOS", "TEVEZ","ELAVNCDEO","VPDZTCSRM","MDVNCDP"));

        allQuestions.add(new Questions("Which European club has the motto that means in english : \"More than a club\" ?\nHint:Lionel Messi plays for that club.", "CCOAPBYHBFWALRENSC", "FC", "BARCELONA" ,"OELDBZRJF","CLCGNAAOW","WZOGDJL"));

        allQuestions.add(new Questions("The first modern Olympics where held in which year ?", "196325874189512357", "1896", "","917232","638649","97232634"));

        allQuestions.add(new Questions("In rugby, each team starts the match with how many players (in words) ?", "YTQNWPFSXETFEIJXJD", "FIFTEEN", "","EDWTFGB","ENRIUFE","BWDREUG"));

        allQuestions.add(new Questions("Which swiss tennis  player has won the most men's Grand Slam titles & even analysts have called him the greatest male tennis player of all time ?", "RRBOVEQAEFRWEREGED", "ROGER", "FEDERER","TEREREOSK","WEGRWFDRD","SWTDKW"));

        allQuestions.add(new Questions("What city hosted the 2012 summer olympics ?", "XOWKHLMEDSOWMNNLBZ", "LONDON", "","UOLOOBZ","OSNRNUD","UUOSZRBO"));

        allQuestions.add(new Questions("How many teams are there in the American National football league (in words) ?", "IYTTQORTUTWOWKXHFM", "THIRTY", "TWO","HLIWYRJI","TTTATJOI","ILATJJI"));

        allQuestions.add(new Questions("In 1924 the first winter Olympics was held in which country ?", "LVFPRNCTWFNAEXTRAX", "FRANCE", "","WPFBNRG","QWCENQA","PNQWWQBG"));

        allQuestions.add(new Questions("The National game of india is ?", "KEODSPEVZRPICWYYJH", "HOCKEY", "","COYEQMN","KOAWHGH","GAQHWONM"));

        allQuestions.add(new Questions("The Number of players on each side in baseball is ?", "VQOIERFIXNOVTUFERN", "NINE", "","RNIPGJ","WENNNQ","GJNNQRPW"));

        allQuestions.add(new Questions("Which Spanish professional footballer has married with Colombian singer Shakira who he first met when he appeared in the music video for her single \"Waka Waka (This Time for Africa)\" ?", "GCREDASQHMRWEZIPUU", "GERARD", "PIQUE","IDQAKUQEE","RGYRZRPRM","ZQMKRRY"));

        allQuestions.add(new Questions("The meaning of the motto citius ,altius ,fortius of the olympic games is \"Faster , _____ , _____\" respectively.", "RSHMGTRHMROGNIEYEU", "HIGHER", "STRONGER","HORVTSAEV","HRSIRGNGE","VAVS"));

        allQuestions.add(new Questions("Maradona is a famous retired football player of which country ?", "RTATDIEXIAZSNGZBTN", "ARGENTINA", "","ORDIGMEI","AANRNMTA","AMMIROD"));

        allQuestions.add(new Questions("Guess the name : In 2011 ,_____ won the \"world soccer young player of the year award\" and in the same year he won the \"FIFA Puskas Award\" for scoring the best goal of the year.", "SFLYHROYRGIRMNEAMH", "NEYMAR", "","TECRAHV","YMAEMNS","TSMEAVHC"));

        allQuestions.add(new Questions("First Indian cricket captain who has got three consecutive centuries on his first three innings of tests ?", "VKLBOAYLXHYBTJIIWR", "VIRAT", "KOHLI","OAOTEITH","YIVRYYLK","YYOETY"));

        allQuestions.add(new Questions("Olympics Games are organised after a gap of how many years (in words) ?", "RUIVFCMNSEEAFRNIOD", "FOUR", "","JFWARR","SDOUUL","LASRUDJW"));

        allQuestions.add(new Questions("Who won the Most Valuable Player Award three times (1987,1989,1990) in basketball ?", "TAMDONJHCIMGSNOQGI", "MAGIC", "JOHNSON","CNYEXDWBM","AHNGOJOIS","XDBWEY"));

        allQuestions.add(new Questions("Who was part of the Olympic gold winning American basketball team at Beijing(2008) and london(2012) games, and a bronze at seoul Olympics (2004) ?", "ZAOJLBAIKMERSZLENK", "LEBRON", "JAMES","MLWNEASOR","DEUZJGOBV","GZUWODV"));

        allQuestions.add(new Questions("Who was an American chess grandmaster & the eleventh world chess champion. many consider him to be the greatest chess player of all time ?", "IJOBYFNSREOOHBWCBH", "BOBBY", "FISCHER","EEBFBBFSR","IWKYOCECH","EEWCFK"));

        allQuestions.add(new Questions("The first only professional boxer in history to win eight titles in different weight classes. Name him", "UAOYYNCCTAHLMQIANP", "MANNY", "PACQUIAO","CNAUUYAOA","IQYNXMDMP","MXDUY"));

        allQuestions.add(new Questions("In what country would you find the world's largest football stadium (by capacity) ?", "RHANHOTTPONQYREMKJ", "NORTH", "KOREA","OOTHAKJN","RREARGKR","RRAGJK"));

        allQuestions.add(new Questions("Which Brazilian player won two FIFA player of the year awards consecutively in 2004 and 2005 ?", "IIAONHBULHORINDJTA", "RONALDINHO", "","CDONOPRM","NZWILAOH","PCMOWZ"));

        allQuestions.add(new Questions("Guess : He is a retired French footballer and current manager of Real Madrid. He played as an attacking midfielder for the France national team, Cannes, Bordeaux, Juventus and Real Madrid.", "INCENMNYZEEAZDIIZD", "ZINEDINE", "ZIDANE","SIIADEZYI","NENZJUNED","SJUY"));

        allQuestions.add(new Questions("In 1970 , which greatest Ice hockey player was presented with Lou Marsh Trophy that is given to honour Canada's top athletes ?", "OZRVXBYRZUBONFDVRB", "BOBBY", "ORR","BRGOYBB","BQRMOZX","MBZXGQ"));

        allQuestions.add(new Questions("What is the national sports of USA ?", "EAVLSTHEEASOZBWKLB", "BASEBALL", "","EBTAYLJ","NKILSBA","INYKTJ"));

        allQuestions.add(new Questions("Guess : He is an English former professional footballer. He played for Manchester United, Preston North End, Real Madrid, Milan, LA Galaxy, Paris Saint-Germain, & the England national team.", "MAIVKEODDDHCXBUEAI", "DAVID", "BECKHAM","DKHCEAEGK","BAKCVWIMD","WEKKCG"));

        allQuestions.add(new Questions("Which cricketer is popularly nicknamed as \"prince of port of spain\" ?", "HKLADRPSISNAARUPGB", "BRIAN", "LARA","NYRLIJLA","RGYAAYYB","LYGYJYY"));

        allQuestions.add(new Questions("Saina Nehwal is associated with the game of ?", "MPTWNDOBHVKJCAGOIN", "BADMINTON", "","UBDYJAUB","TTIOIMNN","YIUUTJB"));

        allQuestions.add(new Questions("Which country won the World Ice Hockey Championship 2012 ?", "BSSYKCQICSRWAUOGUY", "RUSSIA", "","SUYOSSA","IFBWROR","FYSWROOB"));

        allQuestions.add(new Questions("Which soccer player captains both Manchester United and the England national team & he has a tattoo of the words \"Just Enough Education to Perform\", the title of an album by his favourite band ?", "WOFRENOITEUAXYIYAN", "WAYNE", "ROONEY","COBEWNYPO","ENZRKAOWY","WZOBPCK"));

        allQuestions.add(new Questions("National game of Sri Lanka is ?", "BLPVAKLLSYEQLMIOCJ", "VOLLEYBALL", "","DLASLMEY","LVOLQKBE","DQKSME"));

        allQuestions.add(new Questions("Which basketball great was declared as the \"Greatest Player in the History of the NBA\" by the Professional Basketball Writers Association of America in 1980 ?", "STLLSAISIOURLBLLLE", "BILL", "RUSSELL","SLHHBJRIL","UEHESLSLO","HEJHSHO"));

        allQuestions.add(new Questions("Who won the chess Oscars for five consecutive years from 2009 to 2013 ?", "KGSNAMSEESNCURLALR", "MAGNUS", "CARLSEN","LXHSAMCAS","LRNECSGUN","HXLSC"));

        allQuestions.add(new Questions("\"Floyd ______\"(full name) is an American former professional boxer who competed from 1996 to 2015, and currently works as a boxing promoter.", "MQIAMAPEROYTRTHEWZ", "MAYWEATHET", "","EETTMVGA","YMAWTLTH","TTGMLV"));

        allQuestions.add(new Questions("Zinedine zidane made 1st appearance for which Italian club ?", "QUBCTNBGEVGUJSXXLX", "JUVENTUS", "","VENSAUP","YPJTKUC","PCPAKY"));

        allQuestions.add(new Questions("What is the National game of china ?", "AFONFFSTLTRINEEXNB", "TABLE", "TENNIS","DENTHNIAT","LSEBAPUTE","EAPTUDH"));

        allQuestions.add(new Questions("\"Ever onward\" is the motto of the ______ games.", "IBRNHAAPRSAOAEXEWR", "ASIAN", "","BQAASK","IQUNUJ","KQBUQJU"));

        allQuestions.add(new Questions("National game of France is ?", "IBBLTFHMVUZLDAOOVJ", "FOOTBALL", "","FMAOBFL","TBTBLBO","MBFBBT"));


         //sports medium
        allQuestions.add(new Questions("How many players including the goaltender make up an ice hockey team (In words)?", "LNQNNWEIDSEOOXTTVF", "SIX", "","ZMPNZ","SIXDM","ZDMNPMZ"));

        allQuestions.add(new Questions("What sports is played on the biggest pitch in terms of area ?", "HXJLQJPRUWSGOOXOCB", "POLO", "","IPQRBR","DCPLOO","CBIDPRRQ"));

        allQuestions.add(new Questions("What is the highest score possible in 10 pin bowling ?", "374123065485209658", "300", "","37410","30650","7413650"));

        allQuestions.add(new Questions("What is national sport of Afghanistan ?", "ISULJBKAOPZERPISUH", "BUZKASHI", "","LYJZBHU","DAIKSYO","JOYDYL"));

        allQuestions.add(new Questions("Which game is Lan Thorpe associated with ?", "SGMIQXAGSMILJGWNGZ", "SWIMMING", "","KRINSZI","SGWMCMP","CSRPKZ"));

        allQuestions.add(new Questions("What is national sport of Bhutan ?", "YTQCAUPHRNNEEAXURA", "ARCHERY", "","YZYEYMR","ACEYYHR","YYZEMYY"));

        allQuestions.add(new Questions("The term \"Gambit\" is used in the game of which sport ?", "CSCUHGSSOOFWSSEWNH", "CHESS", "","HIDELA","CEASSE","IELEDAA"));

        allQuestions.add(new Questions("The maximum number of gold medals in Olympics 2008 was won by which nation ?", "BWBACUNTOKHGDSNENF", "USA", "","USAGE","JOBGM","MEBGGOJ"));

        allQuestions.add(new Questions("Guess: In 2011, he was awarded with the ‘Fuenlabrada Golden Medal’ and he was the first recipient of this medal. He has played for clubs like ‘Atlético Madrid’, ‘Liverpool’, and ‘Chelsea’.", "EFADSEQRNIROREOENT", "FERNANDO", "TORRES","FRTESRNMR","EDOJOAONN","OJNM"));

        allQuestions.add(new Questions("Guess: Professional tennis player from Australia earned the nickname, \"Rocket\", which was given to him by his tennis coach.", "DCRVTOAWIOSORLVPDE", "ROD", "LAVER","LVAUKRE","GOKARBD","KABUKG"));

        allQuestions.add(new Questions("Which player won the PFA Young Player of the Year award for 2013-14 from the Chelsea club ?", "DZNACRFRHCEADASEZZ", "EDEN", "HAZARD","YRMAKAEE","DAHNZHPD","MKYHPA"));

        allQuestions.add(new Questions("Who won 2015 Africa Cup of Nations ?", "ORVFIGQYMTSCAECJYO", "IVORY", "COAST","TOLICOVX","DRSYOHRA","ODLRHX"));

        allQuestions.add(new Questions("Terry Gene Bollea, better known by his ring name ______ , is an American semi-retired professional wrestler.", "SWLOLHGNUAHUUUJGKP", "HULK", "HOGAN","WOWDNBLG","HAHLUKMO","BWDOMWL"));

        allQuestions.add(new Questions("In Rio 2016, who won the gold medal for his country china in table tennis ?", "KORNLSHAGXMZMLGCEW\n", "MA", "LONG","CDHLAGM","NOAGANQ","NCAGDAHQ"));

        allQuestions.add(new Questions("The first World Cup (cricket) was organised in June 1975 in which country ?", "VMTEMVDLLOXAGRONNB\n", "ENGLAND", "","NGNPERU","AGPNNLD","GUPPNRN"));

        allQuestions.add(new Questions("National sport of Czech Republic ?", "CTFEIKCYZJZHHYAOSE", "ICE", "HOCKEY","HTCTCEFR","KEHIYZOS","ZTRSTFH"));

        allQuestions.add(new Questions("Which tennis player is know as \"The King of Clay\" ?\n\"Clay\" refers to clay court which is one of many different types of tennis court.", "LGVLLAFDEAAACRWNMX", "RAFAEL", "NADAL","LARFAAAKA","EONODELEM","KMOEEOA"));

        allQuestions.add(new Questions("The first Asian Games was held in which south asian country ?", "IMPITASQJDBKINETUG", "INDIA", "","JDPAGI","MINOGT","JGMTPOG"));

        allQuestions.add(new Questions("Wimbledon cup associated with which sport ?", "PKEESUNNRVANILMTLW", "LAWN", "TENNIS","WEMGWITB","ACLNLNNS","CMWLBG"));

        allQuestions.add(new Questions("What do golfer shout to warm other golfer when they hit an errant shot ?", "EOQZPMFEJVRPEZOCWB", "FORE", "","RBXSEU","QOFRSS","SBRSSQXU"));

        allQuestions.add(new Questions("Shaquille O'Neal retired in 2011 from what sport ?", "BALTNLSFBOSNIAKEVA", "BASKETBALL", "","BBAEEEBL","KTSKLLAF","KEBLEF"));

        allQuestions.add(new Questions("Where did the sport of curling originated ?", "LJLAASNQOZHBDLDCTL", "SCOTLAND", "","CDOASAT","YZSKDNL","DZYKSA"));

        allQuestions.add(new Questions("What was the NBA player Bryant named after  ?", "GLBEJNGOKLBMVEFKEI", "KOBE", "BEEF","OQFEBEB","IKESJLX","QLISJX"));

        allQuestions.add(new Questions("Which Russian professional tennis player was tested positive for a banned substance at the 2016 Australian open ?", "IHMUAAASRPARAJOVEP", "MARIA", "SHARAPOVA","PROVASHHA","LRMLIGAAA","LLHG"));

        allQuestions.add(new Questions("In what year were women first allowed to participate in the modern olympic games ?\n HINT: It was held in paris.", "195175349085214590", "1900", "195075","204590","50752459",""));

        allQuestions.add(new Questions("National game of indonesia is ?", "UTHQTMBZNTFNRODAIW", "badminton", "","TCEAINOU","LBDDYNMH","HDLEUYC"));

        allQuestions.add(new Questions("Guess : He is the all-time top scorer and former captain of the Ivory Coast national team", "IVDEPGIIRFOBUJRADD", "DIDIER", "DROGBA","YIARDODGY","DIKIELBUR","KLIYYU"));

        allQuestions.add(new Questions("______ is a former Indian cricketer who led his team to World Cup victory in 1983.", "KSPXYDVAVPIHCTEIQL", "KAPIL", "DEV","IDVNELK","BAOPCNH","BHONCN"));

        allQuestions.add(new Questions("Guess : She is the first tennis player to win all the four Grand Slams and the Olympic Gold Medal in one particular calendar year.", "AIENHSGTABFFQRGFRH", "STEFFI", "GRAF","SIAFRFOL","TGBLEFRR","ORRBLL"));

        allQuestions.add(new Questions("Who is a professional wrestler turned actor known for his appearance in ‘The Mummy Returns’ & also know as \"The Rock\" ?", "ALCOSLDNNSNYEHOJWC", "DWAYNE", "JOHNSON","CHOCRDYPO","NANWENSYJ","YCCPR"));

        allQuestions.add(new Questions("Who was named the Most Valuable Player (MVP) during the 2010 Asian Games in Guangzhou, China (badminton men's singles gold medalist) ?", "DLUBNDFKTDLAIIANKU", "LIN", "DAN","PAUPNZI","CHDWNUL","CUUWZPPH"));

        allQuestions.add(new Questions("Tennis magazine selected \"______ Navratilova\"(full name) as the greatest female tennis player for the year 1965 through 2005.", "ANARLAATRNOTMVVIIA", "MARTINA", "","ITAPVLN","MDMRWJA","JDLPVMW"));

        allQuestions.add(new Questions("______ a Russian chess grandmaster, former World Chess Champion, writer, and political activist, whom many consider to be the greatest chess player of all time.", "AYRTMARRVSRGAPKSEO", "GARRY", "KASPAROV","ARVOGPAEX","KASYRARJH","EXHAJ"));

        allQuestions.add(new Questions("What is national sports of Russia ?", "BAYFMSMYJYRDENYJIO", "BANDY", "","OUDAAY","BWSYJN","WOJYUAS"));

        allQuestions.add(new Questions("Which cricketer has nicked named \"Punter\" ?", "ICNPQXKNTMGIIORYPX\n", "RICKY", "PONTING","PNEKXTYRF","CKONIIGYB","FYBKEX"));

        allQuestions.add(new Questions("Largest cricket stadium in world is located in which city of Australia ?", "UNBLGOKOMBNRCRNENE\n", "MELBOURNE", "","CNELDEEO","UFMWABRM","DMAFWCE"));

        allQuestions.add(new Questions("International olympic committee is located in which city of Switzerland ?", "ZPAEULPEVNSKUDENAQ", "Lausanne", "","ESANNLU","JALWKAX","AXWJLK"));

        allQuestions.add(new Questions("Viswanathan Anand is associated with which sport ?", "NRERVXUSRLCLHFKMSC", "CHESS", "","SDIOHS","GECVAE","GAIVDOE"));

        allQuestions.add(new Questions("The full form of the term used in cricket LBW is  ______ BEFORE ______.", "WCSEAGHKITLVNEZCKW", "LEG", "WICKET","EGLTUEJF","LCGXUIWK","FJGXULU"));

        allQuestions.add(new Questions("Several members of this great field athlete's family including his father were killed during the partition of India. His father’s last words as he lay dying were “Bhaag, Milkha” (run for your life Milkha).Name the athlete.", "GESJFAKIIMXHOHPILN\n", "MILKHA", "SINGH","MPKIHSAHL","GFGNRENHI","REHNGPF"));

        allQuestions.add(new Questions("National sports of Poland ?", "LGLUOJUHTASOFBLZOA", "FOOTBALL", "","OLQBOUF","GAHLTLB","HGLBQU"));

        allQuestions.add(new Questions("2004 Olympics where held in which country ?", "RPPRYCOKSEGZFEEXCQ", "Greece", "","BOGREEI","EASEVCB","VSAOBEIB"));

        allQuestions.add(new Questions("Where is the baseball hall of fame located in US ?", "RZWGNYWJKEBYEROUSL", "NEW", "YORK","GIRWLTY","KVONEYX","VITLYXG"));

        allQuestions.add(new Questions("Wladimir Klitschko is a champion boxer from which country ?", "KLISKRGVYTUNNMFAEA\n", "UKRAINE", "","IKAINOU","HVRIETK","KVOIIHT"));

        allQuestions.add(new Questions("Which ice hockey player is know as \"The Great One\" ?", "YNKNKEGRZASEMWYATD", "WAYNE", "GRETZKY","QEZYRGWQK","TEEANYSEY","YESQQE"));

        allQuestions.add(new Questions("\"El Clásico\" is a game between clubs against _______ & BARCELONA.", "ADEADMMRIZBLPTQABH", "REAL", "MADRID","NDJALDEI","RRWTOAMM","ONWMJT"));

        allQuestions.add(new Questions("How many NBA Championship did michael jordan wins over chicago bulls ?", "OSEETWNOINTLNPUOWX", "SIX", "","TXLIU","LAJKS","ALJUKTL"));

        allQuestions.add(new Questions("Novak djokovic (Tennis player) is from which country ?", "NTEUSSHZRBIWQPSPAH", "SERBIA", "","IDHIQBE","VSQRGAD","IHDGDQQV"));

        allQuestions.add(new Questions("Which country won the first football World Cup held in 1930 ?", "UAQHEFRSJBVGURXHYU\n", "URUGUAY", "","RPAVYQE","GUUJUZR","ZEPVRJQ"));

        allQuestions.add(new Questions("______, is a football stadium located in Milan(Italy).", "LVMKXSVRNCAJYIOSKY", "SAN", "SIRO","YOESEIA","QBESRNA","BAYEEQE"));

        allQuestions.add(new Questions("Due to players strike which year had no baseball word series it happened second time in the event's history ?", "198746852139998564", "1994", "","198746","998564","87469856"));

        allQuestions.add(new Questions("Which is the only country to have played in each and every world cup ?", "BIIAOBFVWLKANMXZRM", "BRAZIL", "","HYBNVAI","RILIZRJ","INVYIHRJ"));

        allQuestions.add(new Questions("Who was first US volleyball player to win three Olympics gold medals ?", "CLHFRLPAAINKKRHJYC", "KARCH", "KIRALY","MLHKRRYDA","AALKYNCDI","NMDDLYA"));

        allQuestions.add(new Questions("How many players in a rugby league team ?", "FTTKQYROWYIRNHSEBE", "THIRTEEN", "","TRXNDEE","TTIHWZH","TDXZWH"));

        allQuestions.add(new Questions("The creator of sherlock holmes, sir Arthor Conan Doyle was the first keeper for which English football club ?", "RTMHJIHOMOSUMQPETP", "PORTSMOUTH", "","UPWHMRUC","SOWTHOTD","CHWUWD"));

        allQuestions.add(new Questions("Which was the first African country to qualify for a FIFA World Cup in 1930 ?", "TJRVNYEYSHCWEGHJVP", "EGYPT", "","GYNNTY","STQPEH","NSTNQHY"));

        allQuestions.add(new Questions("Floyd Patterson was a World Champion in which sports ?", "IXMNOGHBUOCRSHOYJX", "BOXING", "","TNTDIZN","GIXBOYP","ZPTDINYT"));

        allQuestions.add(new Questions("Which footballer is said to have scored 1281 goals in 1368 games ?", "EPGHUBVKJPREHULUXY", "PELE", "","MEVPBL","AOPGES","GMSABVPO"));

        allQuestions.add(new Questions("In feet how high is a basketball hoop ?", "TSWNDOIMGNOTXNOERE", "TEN", "","NKEEF","FNWHT","EKNFFWH"));

        allQuestions.add(new Questions("______ is a professional footballer who plays as a winger for Spanish club Real Madrid and the Wales national team.", "GEARAEJNTRUSLBWHKD", "GARETH", "BALE","HBXRHLLA","ATETRELG","LLHXRT"));


       //sports Hard
        allQuestions.add(new Questions("The \"Union of _____ _____ Associations (UEFA)\" is the administrative body for association football in Europe. Fill in the blanks.", "TQZHLPMLELEJHRESEE", "European", "Football","ALEOLOOBE","TQFANXPRU","QX"));

        allQuestions.add(new Questions("The 2002 winter Olympic games where held in which US city ?", "HLWUKXTNVZELAPXULK", "UTAH", "","DJITNH","VSUYYA","NJDSYIVY"));

        allQuestions.add(new Questions("What is the name of Atlantas's major league baseball team ?", "ELRQBTSVTVNAFASSAA", "ATLANTA", "BRAVES","BAWEAVYSL","RFNTNATAJ","WYJNF"));

        allQuestions.add(new Questions("Which English Premier League football club has the motto ‘Audere est Facere’ (To Dare is to Do) ?", "TOHTQOHOPTNSTAUMRE", "TOTTENHAM", "HOTSPUR","ENMPATTOU","HTTSOTMHR","MT"));

        allQuestions.add(new Questions("Durbey Cup associated with which sport ?", "KSECREAOREEXRYHGJL", "HORSE", "RACE","CRHTYCET","LPRARESO","PTLTYCR"));

        allQuestions.add(new Questions("The five rings on the Olympic symbol represent five ______ ?", "DCCZINECINNYTTOSQD", "CONTINENTS", "","ZEOATTLN","SNNCGIIO","AZLOIG"));

        allQuestions.add(new Questions("The 1968 winter Olympics where held in which French city ?", "EBJSLBNIMBHPCEOGWR", "GRENOBLE", "","EPZOLEB","KZNGQTR","ZZTPQK"));

        allQuestions.add(new Questions("Who created a new Olympic record in 100 m event at London Olympic 2012 by finishing the race in 9.63 secs ?", "XISLSLTSNODGBKYATU", "USAIN", "BOLT","UBHOITAT","DNALLEAS","HTAEDLA"));

        allQuestions.add(new Questions("Olympic games were held in ancient Greece in the honour of Greek God ________.", "YAPZJDUEDBZWGQFRSS", "ZEUS", "","QCLXUE","GHLSZV","LHGQLCXV"));

        allQuestions.add(new Questions("Europe's largest (NOT WORLD LARGEST) football stadium name which is located in Barcelona is ?", "OPOHXWUAUTHCDNMTOB", "CAMP", "NOU","OVGMVCU","OWAWNJP","VGWWVJO"));

        allQuestions.add(new Questions("Who became the second indian captain after kapil dev to win the icc 50 World Cup for India ?", "PHOMHREDNNQISKZIFY", "MS", "DHONI","DHOWXNB","NDIISMA","BWADXIN"));

        allQuestions.add(new Questions("National game of Argentina is ?", "PTIOPUPVAOSWHMDGOC", "PATO", "","YJOTPA","OYZTGU","JOYYTUZG"));

        allQuestions.add(new Questions("Saina Nehwal is associated with which sport ?", "DNOUIBGNATKNRFGBNM", "BADMINTON", "","ORDOBNTW","NCTRBAMI","COBWTRR"));

        allQuestions.add(new Questions("Guess :Nine-time Olympic swimming champion once sported a famous moustache, considered his trademarkand even he was nicknamed \"Mark the Shark\" by his teammates.", "TZNNTWISCAKRKPBZMZ", "MARK", "SPITZ","KTWZARFI","PRSRIRKM","KWRFRRI"));

        allQuestions.add(new Questions("Deepika Kumari is associated with which sport ?", "YYIXAEMNCHMHMHIRRR", "ARCHERY", "","GHERCKA","KXUSYRC","KGKCXUS"));

        allQuestions.add(new Questions("In which city is the headquarter of FIFA governing body located ?", "XUCIOBOTPHZBTHLQRY", "ZURICH", "","HSIUXZC","RRVANES","SAXRVSNE"));

        allQuestions.add(new Questions("Which Grand Slam tennis tournament start first in the year ?", "VRNNADEPIAITBSLUAO", "AUSTRALIAN", "OPEN","KEOPKAITS","RULMTAANN","KKMT"));

        allQuestions.add(new Questions("Which one is the oldest running Grand Slam tennis tournament ?", "DLMTGMNAZOHEBLWLIY", "WIMBLEDON", "","UIMLBENC","RWHSODIO","SRUHIOC"));

        allQuestions.add(new Questions("The 2014 winter Olympic was held in which city of Russia ?", "IEHSSCFORRNOHZODJX", "SOCHI", "","CINSHO","SIUCBC","BCUNCSI"));

        allQuestions.add(new Questions("In the game of snooker, how many balls are present on the table at the beginning of a game ?", "PMHOWNVYTQKTEXGWTX", "TWENTY", "TWO","WWOTAZFW","ATLNYGTE","WLZFAAG"));


        allQuestions.add(new Questions("Santiago Bernabéu famous football stadium is located in which city of spain ?", "RMDRIAORKRHBCNEEDC", "MADRID", "","MIMJKPM","AADPEDR","EPJMPMKA"));

        allQuestions.add(new Questions("The headquarter of International Cricket Council is located in which city ?", "XMMKLITQBIUIFFRODA", "DUBAI", "","IANEDH","FZABUO","HZNEAOF"));

        allQuestions.add(new Questions("Official distance of marathon race is ____ miles and ___ yards.", "269633258874168515", "26", "385","269633","168515","9631615"));

        allQuestions.add(new Questions("The length of a cricket pitch is ___ yards.", "296332588741685152", "22", "","296332588","741685152","9633588741685152"));

        allQuestions.add(new Questions("Who is the winner of Champions League 2013 ?", "HPSDEUYTQBCRANWINM", "BAYERN", "MUNICH","MYMTFIBRT","RCGNUANEH","TFTGRM"));

        allQuestions.add(new Questions("2014 Asian Games took place in ?", "OAJGSCAEHQUFTKFORE", "SOUTH", "KOREA","XSONNAOE","SHUTRNUK","XNUSNN"));

        allQuestions.add(new Questions("From which year the Ashes series begin ?", "182963325887416882", "1882", "","182963","416882","29634168"));

        allQuestions.add(new Questions("The World Athletics Championship is held after a gap of how many years ?", "OSTEUONWTQNJXBEISN", "TWO", "","OUTWJ","TVGVU","TVVGUJU"));

        allQuestions.add(new Questions("Who is the first Saudi Arabian track and field athlete to participate in Olympics Games ?", "ATPAACRPTARLHAZDSE", "SARAH", "ATTAR","RTRAAHJS","AFEYANAT","JEFANY"));

        allQuestions.add(new Questions("William G. Morgan is Known as the inventor of which game ?", "HRONKBLEHEYLPALLXV", "VOLLEYBALL", "","HREQOLQO","VBLAYQLL","QQHQOR"));

        allQuestions.add(new Questions("Cassius Clay is the born name of which boxer ?", "LHCSMNMYCAIAAMUBMD", "MUHAMMAD", "ALI","UVMMDHAAG","CRMLCILAS","RGLCCSV"));

        allQuestions.add(new Questions("\"_____ _____\" is a renowned American surfer, famous for his record breaking 11 wins at the ‘ASP World Tour’.", "LSYTYEKLWLNLAREMYT", "KELLY", "SLATER","BNWIUASWL","LLRIEETYK","UWBIIWN"));

        allQuestions.add(new Questions("Manchester United set a new transfer record in 2016 to sign which player from juventus ?", "UQYADGPLPXBWIOAXBA", "PAUL", "POGBA","CGRUJEGO","AMCBLPAP","CRGJCME"));

        allQuestions.add(new Questions("'I'm Not Really Here' is the title of the autobiography of which former Manchester City midfielder ?", "TAEYWULLALUKPIRLGB", "PAUL", "LAKE","KNAGULL","ALGZPGE","GGZGNL"));

        allQuestions.add(new Questions("_____ ______ nicknamed \"White Lightning\", is an Australian professional surfer. Fanning won the 2007, 2009 and 2013 ASP World Tour.", "MIUVNMGVKAFMWNNICM", "MICK", "FANNING","CISFANINC","MBGJXKGBN","XSBCGJB"));

        allQuestions.add(new Questions("Ron Atkinson managed which English club between July 1991 and November 1994 ?", "PDMAHNROTLISVATGUL", "AstonVilla", "","OCRMLAET","ATIVSNJL","EJTRMC"));

        allQuestions.add(new Questions("Which Uruguay striker played for Nacional, Gronigen and Ajax before signing for Liverpool in 2011 ?", "BMSELAUZUSLIKPUBSR", "LuisSuarez", "","EUSZUSLI","AHGUMIRX","GUIXHM"));

        allQuestions.add(new Questions("In 2006, which striker topped a Liverpool fans poll of '100 players who shook the Kop'?", "PGNLLHSKJAEGDYSMNI", "Kenny", "Dalglish","KNLSKDLNA","IIQGCEHYL","CQKLI"));

        allQuestions.add(new Questions("Who was manager Chelsea between June 2004 and September 2007 ?", "DNMJOROIHOJEUMSMPJ", "Jose", "Mourinho","SCWMZZIHO","QHUOJNREO","CZHQWZ"));

        allQuestions.add(new Questions("Which English Football League are known as The Tykes ?", "HSHRMBLENTMQAYCPVU", "Barnsley", "","SCYAMEB","ELVLGNR","MGVLCE"));


        allQuestions.add(new Questions("When swimming, what stroke provides the fastest world record times in the 100-meter and the 200-meter races ?", "TUTBNJKEUOYRLJFTWU", "butterfly", "","HBFERYUT","DGLBITVO","BIOGVDH"));

        allQuestions.add(new Questions("Which team won the FA Cup in both 2013-14 and 2014-15 ?", "VLRMAWFQAIDDEASHRN\n", "Arsenal", "","AADLURJ","SJSFKEN","FKJUSJD"));

        allQuestions.add(new Questions("Which English club won the European Cup in 1981-82 ?", "HETLKVLIOMAFNIALSL", "AstonVilla", "","ALSAFTNI","NZVOCVLC","ZCNCVF"));

        allQuestions.add(new Questions("Which former Manchester City manager was known as 'The Charming Man' ?", "GNLRNMILAUIPEEMELA", "Manuel", "Pellegrini","PLLGRIEIU","LNMNLAUEE","UL"));

        allQuestions.add(new Questions("Who has been named as the International Boxing Association (AIBA) ambassador for Women’s World Championship from india ?", "MOERWYRWMPYMLUANZK", "Mary", "Kom","YCXZYMK","MAFORSS","SSFYZXC"));

        allQuestions.add(new Questions("“Hopman cup” is related to which sports ?", "NLLLJPEMAMWIOLTANS", "Law", "Tennis","ENICLJWT","ANIJMFSW","FJCJMIW"));

        allQuestions.add(new Questions("Who has won the 2016 Formula 1 Gulf Air Bahrain Grand Prix ?", "HIWIBRCEDRXONGGOOS", "Nico", "Rosberg","HNMCGWCIR","OSRVONEBE","HNECMWV"));

        allQuestions.add(new Questions("During the 1980s, who won nine New York City marathons ?", "ITMTGZIZAZEGFVWREU", "Grete", "Waitz","UGTJTWZE","QRIAEVZN","QJUNVZ"));

        allQuestions.add(new Questions("Which company has become the BCCI’s official associate sponsor for four years in 2016 ?", "DQZUIOPCHOESYIGKPO", "PEPSICO", "","ELJPGPO","PSFCVIL","GPLLJVF"));

        allQuestions.add(new Questions("Who has won the ATP Argentina Open 2016 ?\nRafael Nadal lost against him in the semifinals.", "CMLOXOOITDIAMHITNE", "Dominic", "Thiem","ICNNJECIU","DIHDDMMTO","CJUDND"));

        allQuestions.add(new Questions("Who has won the 2016 Malaysia Masters Grand Prix Gold Badminton title ?", "VSLDPUJVRNDDPHMIMS", "PV", "Sindhu","PCIUYTD","RKNSVNH","TNRKYC"));

        allQuestions.add(new Questions("Who has become the first Russian to be inducted into International Tennis Hall of Fame ?", "AFNMEFSMIANRSKATOJ", "Marat", "Safin","ATWPQAIA","FLSSRNLM","SPLQWL"));

        allQuestions.add(new Questions("Who has won the 2015 FIFA Ballon d’Or award ?", "NIIUSEOELEMRALSXES", "Lionel", "Messi","EDTEISLNL","XMPLSJIOS","XJDLTPS"));

        allQuestions.add(new Questions("Minimum age limit for the gymnasts participating in the Olympic Games is ?", "195158753496485218", "14", "","219515875","496485218","2195587596485218"));

        allQuestions.add(new Questions("In what game is the word 'love' used ?", "JISRGSDTENNYTJCFSD", "TENNIS", "","SGTKEHK","NUINETZ","TKUZGHKE"));

        allQuestions.add(new Questions("The national sports of Canada during winter is ice hockey & during summer is ________.", "COXLINGSSELQAPUSCR", "LACROSSE", "","CDEGRSE","OLSZASP","DPESGZ"));

        allQuestions.add(new Questions("The National Game of south korea is ?", "AVOBPNEKFLNDGWOKET", "Taekwondo", "","WTKOXZND","OLKAEHIE","XLKZEHI"));

        //allQuestions.add(new Questions("Famous Tennis player Stefan Edberg belongs to which country ?", "SSZEODWCQQKNXLWYFE", "Sweden", ""));

        allQuestions.add(new Questions("In the game of Chess each player begins with ___ knights and ___ pawns ?", "729512587469325698", "2", "8","729512587","469325698","7951257469325698"));

        allQuestions.add(new Questions("On a darts board, what number is diagonally opposite to 19 ?", "151258746929325698", "1", "","151258746","929325698","51258746929325698"));

        allQuestions.add(new Questions("What is the highest possible break in snooker ?", "151558746959325698", "155", "","15155","59325","1559325"));


        //geography easy
        allQuestions.add(new Questions("In what country is the Leaning Tower of Pisa located ?", "EMWRATRURTTGLHIAYL", "ITALY", "","YPIOAI","CLBOTO","PBCOOOI"));

        allQuestions.add(new Questions("What is the capital of United Kingdom ?", "GFBSJNNOLJFXZOUFXD", "London", "","YLPYOZA","NOENDSW","AWPSYYEZ"));

        allQuestions.add(new Questions("What is the largest country in North America ?", "AAADMCNYPTAPRRDCTB", "Canada", "","FXNDNAC","TAYLMAZ","LMNYZFTX"));

        allQuestions.add(new Questions("What is the tallest mountain in the world ?", "EEOVRSNMUCODHBWETT", "Mount", "Everest","TPTOEYREU","NMMEVEPKS","YEKPMP"));

        allQuestions.add(new Questions("What is the fastest flowing river in the world ?", "XXNMANEZKVAHZAOKFM", "Amazon", "","OAZMKON","ZYALQYB","OQBYKLYZ"));

        allQuestions.add(new Questions("The Taj Mahal is located in which Indian city ?", "ARTNPMXGLADLSNMWPT", "Agra", "","EUDRWF","AQGNXA","QFDWUENX"));

        allQuestions.add(new Questions("What is the capital of Germany ?", "VSRUBIMFFEDLHVENNB", "Berlin", "","PFBRBNI","JMEXDKL","MDKBXFPJ"));

        allQuestions.add(new Questions("Which state of the United States is the largest ?", "PGRVGMKAKCMAUQNSAL", "Alaska", "","AAZWKAC","LSCLHAV","ZALWHVCC"));

        allQuestions.add(new Questions("Atlas mountain is in which continent ?", "IRSATSWMRCFBNQCATQ", "Africa", "","AFRCQCI","XKAYDSF","SDKQYFCX"));

        allQuestions.add(new Questions("Five oceans of the world: ______ , Atlantic, Indian , ______ , Southern(Antarctic).", "PICCWOFITITCAIRCAT", "Arctic", "Pacific","FCYCIIIAP","RBCITCBAF","YBIBF"));

        allQuestions.add(new Questions("Where is famous Opera House located in Australia ?", "VGQSNRYZWUZQYDEQAK", "SYDNEY", "","HNSSEYW","QYXIJDY","JHWISQXY"));

        allQuestions.add(new Questions("What is the capital of Egypt ?", "RMBOOUKCFDNIDMFPRA", "Cairo", "","LWOIHT","AVXCMR","HLXTVWM"));

        allQuestions.add(new Questions("Study of the Universe is known as ?", "OYPRPZOOYCGSLMAOSG", "Cosmology", "","MVYRLOOG","DOLSCOSS","RSSVDOL"));

        allQuestions.add(new Questions("Pyrenes Mountain is in which continent ?", "UKZETTRUPRBOVETPSG", "Europe", "","RUEOEET","ZVFYVLP","VTYEZLFV"));

        allQuestions.add(new Questions("What is the name of the world's highest uninterrupted waterfall which is located at Venezuela ?", "KLNSAJRYLXACEGWBLF", "Angel", "Falls","LGIMASML","SNFEEXAL","XEIMMS"));

        allQuestions.add(new Questions("The Eiffel Tower is a feature of which European city ?", "ICPMKJHTKAHAWVJRYS", "paris", "","IAPFPR","ASMGTG","FAGGPMT"));

        allQuestions.add(new Questions("What is the capital of Russia ?", "QMCVENBBFKSOTOYFWR", "Moscow", "","WONCPUO","YKOBSCM","YPNOKCUB"));

        allQuestions.add(new Questions("Seven continents are Asia, ________ , North America, South America, Antarctica, Europe, and _________.", "RCFAAAIJRLIUAIUTSA", "Africa", "Australia","LFISARIBC","ARRLTAUAA","LBR"));

        allQuestions.add(new Questions("Rockies mountain is in which continent ?", "AICRRHMBNNATKSOGOE", "North", "America","ICAMOCETR","OHRNIBEAK","ECIBOK"));

        allQuestions.add(new Questions("What is the only sea on Earth with no coastline ?", "AMSOSSGNRXEAMKAVRX", "Sargasso", "","AYOSRZH","GSULSAC","HZLUCY"));

        allQuestions.add(new Questions("The Great Pyramid of Giza can be found in what country ?", "YVJKMAEPBLGTMYOXNA", "Egypt", "","OTUGES","OIMYQP","SMUOIOQ"));

        allQuestions.add(new Questions("What is the capital of Sweden ?", "ISMLKUCRHOCHZTOSBK", "Stockholm", "","XNHOOCTK","XQXLHMST","XHXNTXQ"));

        allQuestions.add(new Questions("Which city is also known as \"Eternal City\" ?", "QMGBRIPQAEPIYMHDOH", "Rome", "","ENOMRL","CCEHDO","HENLCODC"));

        allQuestions.add(new Questions("In what country would you find Mount Kilimanjaro ?", "ANRIICPNGTRATQIZAG", "Tanzania", "","NAZISRI","KBKATAN","KBIRKS"));

        allQuestions.add(new Questions("By area, what is the smallest ocean in the world ?", "ACJCZLENTRZISNHPDJ", "Arctic", "","RVLCNRI","TEACLTR","LRVLETRN"));

        allQuestions.add(new Questions("Which Planet is dwarf planet ?", "PBBEULDROALOUPPGST", "Pluto", "","LCJTOM","GPQUMR","RJCQGMM"));

        allQuestions.add(new Questions("Which country is also known as land of rising Sun ?", "NRSWXAIBOBAPWWSBNJ", "Japan", "","KAPZXA","QNJQWC","QZQKCXW"));

        allQuestions.add(new Questions("What is the capital of Iran ?", "TYOADTNXJERHZQTUKC", "Tehran", "","AEAGRMN","TDZZOHQ","GZOMAZQD"));

        allQuestions.add(new Questions("CN Tower is located in which city of canada ?", "TRTSOLUNXRCHOIKMOL", "Toronto", "","HOTRHCN","IGOYTOM","MICHYHG"));

        allQuestions.add(new Questions("What is the capital of Czech Republic ?", "GCYUWPIJNMEAQLTRFH", "Prague", "","VAEXGQU","RQGPKQP","KQGQQVXP"));

        allQuestions.add(new Questions("The island of Great Britain comprises the nations of _______, Scotland and ______.", "LSGIDCMWBALENNDSEA", "England", "Wales","DUDEAGLCL","WNJEAEFNS","DEFUCJ"));

        allQuestions.add(new Questions("Which is the longest continental mountain range in the world ?", "DFVSSXYPAURNNYEJUR", "Andes", "","NAVXEE","SDFFBS","VBSFXEF"));

        allQuestions.add(new Questions("What is the world's largest ocean ?", "CXCGFALPNIYPPMIIEO", "Pacific", "","HICEPIT","YWMCFAY","TMYHEYW"));

        allQuestions.add(new Questions("Stonehenge is located in which country ?", "YEIAYGLNGDNUTFWNZQ", "England", "","ALALFON","DTGOERN","FOLOTAR"));

        allQuestions.add(new Questions("What city is the capital of Canada ?", "DONRGXATUBTAWWTCRE", "Ottawa", "","UZWYORA","SZTTTMA","UZSZMRTY"));

        allQuestions.add(new Questions("Which country lies on the border between Spain and France ?", "OWNKDDORGEAXINEEAR", "Andorra", "","AGEQSPL","MDOARRN","MPQGESL"));

        allQuestions.add(new Questions("Al Arab is located in which city of United Arab Emirates ?", "LSBJUHIWVQFAMUDFBP", "Dubai", "","BAIXGN","DIUZUK","XGIKZUN"));

        allQuestions.add(new Questions("The Black Forest is located in what European country ?", "ZBAGMFYNYRHREMAACQ", "Germany", "","VMEGKAR","NZZEYPZ","PZKZEZV"));

        allQuestions.add(new Questions("What is the capital of the Republic of Ireland ?", "ABDLOCLYDDRTUGIDNA", "Dublin", "","LTAIXNU","CQKALBD","CTKXAQLA"));

        allQuestions.add(new Questions("Portugal is bordered by what other country ?", "GVGXWSMINONNVPAQAN", "Spain", "","AMBNTN","SNEICP","NBECTMN"));


        allQuestions.add(new Questions("In what city is the The Louvre or the Louvre Museum  located ?", "LNEAACVAWSMIWLGRPS", "Paris", "","QZOSPR","WAYYIR","RYYOWQZ"));

        allQuestions.add(new Questions("What city is the capital of China ?", "INIJVEGIOUAZGBUDMS", "Beijing", "","TOIJCCF","GEBNRUI","CCFRTUO"));

        allQuestions.add(new Questions("Which is the largest hot desert at 3.5 million square miles (9 million square kilometers) located in Africa ?", "ASAMRHJAWNRJDOQJDA", "Sahara", "","ZFNBARH","ASBGSGA","GGFSBNZB"));

        allQuestions.add(new Questions("In which U.S. state would you find Mount Rushmore ?", "WVZOATHROUDTZPKAVS", "South", "Dakota","SKAXAOHDT","AUTUDFOBJ","DJXBAUF"));

        allQuestions.add(new Questions("Sri Lanka is surrounded by ________ ocean ?", "IEIWAYPXSAJDNMNZPN", "Indian", "","NNBAIPD","OIKPNEM","PNKMBOPE"));

        allQuestions.add(new Questions("In what city is the Golden Gate Bridge located ?", "OSARDASNKCIGXCNYSF", "San", "Francisco","ISCONDXAF","USCATRHNO","TXDOHU"));

        allQuestions.add(new Questions("What is the capital of Costa Rica ?", "JUESDYROVFSNVROUAS", "San", "Jose","AMNESSO","YDMJIBK","IBMKDMY"));

        allQuestions.add(new Questions("Madagascar is an island located of the southeast coast of what continent ?", "PRAILRRWIJHFFHSIAC", "Africa", "","LCCAMYC","UCFADRI","DCMCUCLY"));

        allQuestions.add(new Questions("Which mountain range lies between China and India ?", "SAILSVHAZAAUQYYOYM", "Himalayas", "","SCYHDMIE","LASKAAFA","DCASEKF"));

        allQuestions.add(new Questions("What is the longest river in the UK ?", "NMEJRVEEDVWKRLSVIR", "River", "Severn","EVWICDZVE","SEFRORRRN","CFWOZDR"));

        allQuestions.add(new Questions("Niagara Falls is located in between US and which other country ?", "NPCNGAXJUATJGDANGU", "CANADA", "","UAADVCF","LZAKWRN","VZLRFKWU"));

        allQuestions.add(new Questions("What is the capital of Denmark ?", "GOYZNHUUPWENEERGCA", "Copenhagen", "","CPALPPSA","HGNEONKE","ASPKLP"));

        allQuestions.add(new Questions("Which city has the largest population in the world ?\n Hint:It is located in japan.", "OZLOSIISUYTOTYMJLK", "Tokyo", "","YTLAOO","KBZOMF","OBLZAFM"));

        allQuestions.add(new Questions("Long Island is a part of which US state ?", "PMOIRKNRYMQMSRNEMW", "New", "York","RYJNWKF","OCJBBRE","BJJFRBC"));

        allQuestions.add(new Questions("What hills border Scotland and England ?", "HJTOQJVWOQVFEFRLCI", "Cheviot", "","IQBEHRV","VGCEUTO","EVGRUBQ"));

        allQuestions.add(new Questions("In what country would you find the Yellow River ?", "CDWNAZVGZRFIMZHAJE\n", "China", "","ADACIH","RRNNXB","BNRDAXR"));

        allQuestions.add(new Questions("Where is the Blue Domed Church located in Greece ?", "SOTNIIAQLCNFBOASIR", "Santorini", "","ZPNSKQPS","NTCIRAIO","QPZSKPC"));

        allQuestions.add(new Questions("What is the capital of Spain ?", "MIDRVHTMJZAMKOTXPD", "Madrid", "","NBNDMBI","LDRJHVA","HLJBBNNV"));

        allQuestions.add(new Questions("How many times zones are in Canada (in words)?", "EOWVNQNOXQNESTIGTE", "six", "","XCJUT","SRISO","RUOTSJC"));

        allQuestions.add(new Questions("Which planet is closest to the Earth mostly ?", "WPEVNBXJZEIUUXJSCK", "Venus", "","CUVSHX","EQQPNB","QBHCPQX"));

        allQuestions.add(new Questions("Europe is separated from Asia by which mountain range ?", "QQRSAAQSUXTALRCQHJ", "Ural", "","CNALCB","WERUPJ","CNBCJWPE"));

        allQuestions.add(new Questions("In which European city is the Atomium ?", "UFXZIYHALESPXBBRSS", "Brussels", "","VLBSHSU","AVUSARE","AVUVAH"));

        allQuestions.add(new Questions("\"Lake _____\" is the largest lake in Africa.", "GEPIRZTUCOIJBAVUBV", "Victoria", "","WAOUCVL","DIORITL","DLULOW"));

        allQuestions.add(new Questions("In What city is Brandenburg Gate located ?", "MLEUSQIHUNLACJNYRB", "Berlin", "","SNTWBIE","LTNRKIC","NIKCWTTS"));

        allQuestions.add(new Questions("What is the capital of Indonesia ?", "BZRANKCJZLBTIAESGA", "Jakarta", "","HKRAVEA","UTKAJPJ","UPJHVEK"));

        allQuestions.add(new Questions("The Challenger Deep in the ______ Trench is the deepest known point in Earth's oceans.", "AJNMSJRANIXAJQVLNV", "Mariana", "","QLNIMUR","APAARVN","QVLNUPR"));

        allQuestions.add(new Questions("What city connects two continents ?", "TDAKUSIAUEHNLFNBGU", "Istanbul", "","PBSTXDU","LGAINCF","PGXCFD"));

        allQuestions.add(new Questions("What is the world's largest active volcano ?\n Hint:It is located in Hawaii.", "APLAAMNFUOIAXLPANS", "Mauna", "Loa","ADZWSLO","OMAANUF","OSZWDF"));

        allQuestions.add(new Questions("The Southern Ocean surrounds which continent ?", "XNHATAICDAACRXTCMT", "Antarctica", "","AACTEPAB","IRZNECPT","EPEBPZ"));

        allQuestions.add(new Questions("St. Basil’s Cathedral is located in what city ?", "WWBQOVSCMHPXOOHAYS\n", "Moscow", "","MWNKCOH","SEQOQLU","EKNLHQQU"));

        allQuestions.add(new Questions("The Wailing Wall is located in what country ?", "GZEOIPSAHNWMSCLKJR", "Israel", "","AMWISLX","GERKJCM","WMKGCJXM"));

        allQuestions.add(new Questions("What is the capital of Brazil ?", "RATYSIIZBYIDVLAOAL\n", "Brasilia", "","HALGTOI","RRBAHIS","OHHRTG"));

        allQuestions.add(new Questions("What is the capital of Afghanistan ?", "CFLBJRAPODTGHUVYKL", "Kabul", "","TBKMLN","AUFIEA","AINETMF"));

        allQuestions.add(new Questions("Which US state has the nickname \"The Treasure State\" ?", "MAFYXNMTAQUHNYONWF", "Montana", "","ONJKHZA","NPMTWAB","WKBZPHJ"));

        allQuestions.add(new Questions("What canal connects the Pacific Ocean to the Atlantic Ocean ?", "QAFYPANBHMEAGFXWND", "Panama", "","APPPYMR","AFNMSAK","PSKPYMFR"));

        allQuestions.add(new Questions("Canada's highest mountain is located in which province or territory ?", "HMDKNUBYFHBVGFDODY", "Yukon", "","YHLNUK","LUFOYN","LNYLHFU"));

        allQuestions.add(new Questions("In what city Tower Bridge located ?", "DJCABONQDMXZQLNTLO", "LONDON", "","XPGBNCX","LMZDNOO","PCXBMZGX"));

        allQuestions.add(new Questions("Which country is locked within Belgium, Germany and France ?", "UZMBGBORXQBUMMRELU", "Luxembourg", "","XLURHEXI","BGMLUDUO","XDILHU"));

        allQuestions.add(new Questions("Titanic was a British passenger liner that sank in the \"North _________ Ocean\" in the early morning of 15 April 1912.", "ALVTMGEDTCTARYBNIC", "Atlantic", "","CIXNXTT","AECAQLN","XQCENX"));

        allQuestions.add(new Questions("What is the world's smallest country ?", "CVYAATTTIPJINECKVS", "Vatican", "City","YCIANTTIC","ABFDTVVLB","VDBBFTL"));


         //geography medium
        allQuestions.add(new Questions("In what country can you visit Machu Picchu ?", "OEYLTFHRJBCWZUHEPZ", "Peru", "","SEDKPU","HPYRHU","PHKSDHYU"));

        allQuestions.add(new Questions("What is the capital of Qatar ?", "DHFQRHOXLTZAUPSUDQ", "Doha", "","DAHVTO","ROUAZH","ORHZUTVA"));

        allQuestions.add(new Questions("What country is geographically separated from continental Europe by the Pyrenees mountains ?", "NIEOAXCWWMVYMKTSPU", "Spain", "","CAEQJU","PPNISC","CPEQCJU"));

        allQuestions.add(new Questions("What is Europe's longest river and national river of Russia ?", "AEHYYLNEOGDTIMZLVL", "Volga", "","VLNRGL","MEAODG","EGRDMNL"));

        allQuestions.add(new Questions("What river runs through Paris ?", "WECZTVISBOSSQDEJNI", "Seine", "","NUPBEQ","RSEXIG","UQRXPBG"));

        allQuestions.add(new Questions("Bali is located in which country ?", "DDRLIPANSPSNZEIOOQ", "Indonesia", "","DISGETZI","NHONQSAY","ZQSYGTH"));

        allQuestions.add(new Questions("What is the capital of North Korea ?", "GOWIYGLNYAUYPNDYUQ", "Pyongyang", "","NGYDAQNE","GPSIYLEO","SIEQLED"));

        allQuestions.add(new Questions("\"Titan\" largest satellite in the Solar System is of which planet ?", "TNPXGRQUJWRSASKEBZ", "Saturn", "","XTUHYVF","NAJRSFD","YFDJVFHX"));

        allQuestions.add(new Questions("What is the tallest mountain in Europe ?", "XRNTSGOENLUSBVMULY", "Mount", "Elbrus","YOSMBRNLE","TOEURNBUE","EYRONEB"));

        allQuestions.add(new Questions("Which is the longest river in the USA ?", "RGGMIIZFOUSSIKEAUI", "Missouri", "","OGISSBR","UOGEMBI","BEGOGB"));

        allQuestions.add(new Questions("Mecca is located in which country ?", "URBRAJVNVIUATDIASA", "Saudi", "Arabia","NASUAAGHD","IBZIZCGAR","GHCZGZN"));

        allQuestions.add(new Questions("What is the capital city of Australia ?", "NDCRAAYGOABJMEABRJ", "Canberra", "","CAWJEZB","RRAANII","WAZIIJ"));

        allQuestions.add(new Questions("______ , a polar desert covering 5 million square miles (13 million square kilometers), is the largest desert overall.", "VAGAJRQCTCINTALUKV", "Antarctica", "","ARVCTCED","CRAITANT","ECVDTR"));

        allQuestions.add(new Questions("Which Mountain range is in South America ?", "UNSJXNBDEWPUVROASD", "Andes", "","KNARCA","DEQYSX","YXCRKQA"));

        allQuestions.add(new Questions("Chichen Itza is located in which country ?", "XVQEHOCWFWDMTOOIMX", "Mexico", "","AGJEVCH","MXIMOXU","UAHJVMXG"));

        allQuestions.add(new Questions("Which city is traditionally said to be built on seven hills ?", "ZZXBOEWRRCRMHOOKWI", "Rome", "","EBOCAJ","HRKKAM","KCKBHAJA"));

        allQuestions.add(new Questions("How many countries are there in Africa ?", "856598765823149634", "54", "","823149634","856598765","8231963486598765"));

        allQuestions.add(new Questions("What European country is bordered by Slovakia, Ukraine, Romania, Serbia, Croatia, Slovenia, and Austria ?", "HMUFWWRULYGYONIEAN", "Hungary", "","GLRUEYD","SAEGRNH","REESLDG"));

        allQuestions.add(new Questions("Catalonia is a region of what country ?", "JFSHTKPZUZSEZNSARI", "Spain", "","CNASCP","BRIIXX","ICRXCXB"));

        allQuestions.add(new Questions("What is the capital of Uruguay ?", "EFFCTCEOKIXQVOMNBD", "Montevideo", "","ETFGXOQT","MNLVOIED","GQTLFX"));

        allQuestions.add(new Questions("What Hawaiian island is known as \"Bird Island\" ?", "RRHODSZOSNWHCVICAP", "Nihoa", "","PSJAQH","OEGNJI","PJESQGJ"));

        allQuestions.add(new Questions("South Africa completely surrounds which other African nation ?", "NLGGKOUQOEMSQHOCTM", "Lesotho", "","TDHSEZL","TERLOOS","STDRLZE"));

        allQuestions.add(new Questions("What is the largest island in the Caribbean Sea ?", "AXTBQDJCZSVSKGOGUP", "Cuba", "","BBWAQA","KUECMR","AMKWBREQ"));

        allQuestions.add(new Questions("What country has the most coastline ?", "RQVJAAEDUGCNNEGPAC", "Canada", "","SAYAAMD","GBCNGXT","YSMGTBXG"));

        allQuestions.add(new Questions("Which city in the United States is known as the \"Windy City\" ?", "HAQBSMCAOCGYSYOMIC", "Chicago", "","SMALHBO","GICCBDM","BDBLMSM"));

        allQuestions.add(new Questions("What is the capital of Peru ?", "YSRYRWILKWMANCAJUE", "Lima", "","JLAHGE","MWIMGD","WHGMDJEG"));

        allQuestions.add(new Questions("In which US state would you find Stone Mountain Park ?", "RYTYGUXPAPWZOINGEQ", "Georgia", "","ILPFOGA","EOGWRED","DEFLWOP"));

        allQuestions.add(new Questions("What city is the capital of Hungary ?", "TGTZBDPUSJXAFJUEKA", "Budapest", "","DNUZUMS","PTEGRAB","GZRUMN"));

        allQuestions.add(new Questions("The Yangtze River  is the longest river in Asia and the third-longest in the world is entirely located in which country ?", "NHITMHNEWTIMCAGAQK", "CHINA", "","GXCJNH","GAIYRU","GXGRYUJ"));

        allQuestions.add(new Questions("What is the capital of Pakistan ? ", "SUVIMDAXLAKDYHOBAH", "Islamabad", "","AARAMRSI","BJLDZGPO","ZGORRPJ"));

        allQuestions.add(new Questions("Which country is geographically closest to Japan ?", "SUKLPAMSHQVEVROONT", "South", "Korea","BRYENAOH","SFOTRDUK","YDRFNB"));

        allQuestions.add(new Questions("Germany is divided into how many states?", "166598765823149634", "16", "","166598765","823149634","6598765823149634"));

        allQuestions.add(new Questions("The Great Barrier Reef is located in which country ?", "WTAZLAXEWPSANARUIR", "Australia", "","AATUPLOB","AKSIRJUN","PBNKUJO"));

        allQuestions.add(new Questions("The Petronas Twin Towers is located in which country ?", "CIQWAYFJAMDLLWSICA", "Malaysia", "","YAMLSLE","AIMBXYA","EMXLBY"));

        allQuestions.add(new Questions("Which African nation has the most pyramids ?", "UTNANLDMQLSITJNOFB", "Sudan", "","SDPUVF","GNBLAD","FBLGDVP"));

        allQuestions.add(new Questions("_____, also known as Mount Godwin-Austen or Chhogori, is the second highest mountain in the world.", "KFJ63AMDLLWS963423", "K2", "","ZXDPKFA13","OC52NUFVL","CVAFLZON1PXDU5F3"));

        allQuestions.add(new Questions("Along with Spain and France, what is the other country to have both Atlantic and Mediterranean coastlines ?", "ZAYGRHCNNOUOCAMVOJ", "Morocco", "","AUUOOMR","QCHOCSM","MUSHQAU"));

        allQuestions.add(new Questions("What is the coldest sea on Earth ?", "GAPQFHSDWVETMNOJEI", "White", "","RLDHTT","WXTUEI","TTDRXLU"));

        allQuestions.add(new Questions("___ city is the largest US city.", "NBKTBTADIQUQDYAGWJ", "New", "York","YRGKZER","NWOGOPO","GOZRPGO"));

        allQuestions.add(new Questions("Amazon River have __,__ __ __ tributaries.", "116598765823149600", "1100", "","116598","705023","65987523"));


        allQuestions.add(new Questions("\"Christ The Redeemer\" Statue on Corcovado Mountain is located in which country ?", "SERLAYRVRCZLGBHIRO", "Brazil", "","PBUIAZK","YRSYFLM","KMPUFYYS"));

        allQuestions.add(new Questions("The Italian city of _______ is recognised internationally as one of the world's most important fashion capitals, along with Paris, New York and London.", "NYIHAIVNMENLEJGBUW", "Milan", "","MDNZLA","LXRTIL","ZLDXLTR"));

        allQuestions.add(new Questions("What is the capital city of the Philippines ?", "AYLNAZZZQZSYJIGAMC", "Manila", "","UUCQAVH","NLHIMUA","HUHVQUCU"));

        allQuestions.add(new Questions("Sonoran is a desert of what continent ?", "NTNCRARAIGZMHOEGGJ", "North", "America","ARAARCMEM","TYFNRITHO","FRYAMT"));

        allQuestions.add(new Questions("_______, a nation bordered by China and Russia.", "NGONHMVLWZOINUOAYG\n", "Mongolia", "","ARGMOZO","SNLRIGY","GSRRYZ"));

        allQuestions.add(new Questions("\"Oder Neisse Line\" is boundary between which two countries ?", "ONREDNYAPGTMAXLREI", "Germany", "Poland","OGNAYPRND","QGVBADLME","GDVQB"));

        allQuestions.add(new Questions("How many colors are there on the Canadian flag(in words) ?", "XIHWTOUSOROEEEFTRN", "TWO", "","AOZTT","WVCOL","OTLVCZA"));

        allQuestions.add(new Questions("Which U.S. state has the most active volcanoes ?", "AZSSAXAQCLDINLSAYK", "Alaska", "","JYUARSK","BAXGLAB","XBUGYJRB"));

        allQuestions.add(new Questions("What is the smallest independent country on Earth ?", "YCBODNITSRCTAVAIYW", "Vatican", "City","OTVINQECU","ACYANXITP","UONPQXE"));

        allQuestions.add(new Questions("What U.S. state is the \"Land of enchantment\" ?", "CMLYNIXODFEGEHXZIW", "New", "Mexico","EQIEIOZO","HCOWGNMX","QZIGOOH"));

        allQuestions.add(new Questions("What is the most densely populated country on Earth ?", "EFNZCCOOLCNPMALMWU", "Monaco", "","ROACUVY","NFTODGM","RFTDUVGY"));

        allQuestions.add(new Questions("Greece's highest mountain was home to the gods in Greek mythology. What is it called ?", "YEOTMOYPUUNUMTACSL", "Mount", "Olympus","YUSHTPMUM","GNCSGLOOE","SECHGG"));

        allQuestions.add(new Questions("Mount Kailash is in which region of china ?", "TEOKTIDGVTXTBGRYUC", "tibet", "","MEHVCT","WTIRQB","VRMCQHW"));

        allQuestions.add(new Questions("_______ Mountain in Europe border between Switzerland and Italy.", "KRLEJATBGXMTRSOHNT", "Matterhorn", "","HNRATNIO","TKEZMJJR","NZIKJJ"));

        allQuestions.add(new Questions("What is the capital of New Zealand ?", "TNOIGELNQEACOWGNLL", "Wellington", "","NLTONZAP","EWPLGIUP","PPAZPU"));

        allQuestions.add(new Questions("What is the capital of Oman ?", "QBIAVSNFDAVACURMTD", "Muscat", "","XZMACMT","VXSVAUD","XMXAZDVV"));

        allQuestions.add(new Questions("What European country is home to Transylvania ?", "PZXOGARNQFAXMIFGHV", "Romania", "","NIMBRSO","AQLTZMA","QZLMBTS"));

        allQuestions.add(new Questions("What is the oldest city in the world ?", "SRXLADAFIHCMACKUSG", "Damascus", "","GLMDAIC","SJAAMSU","IALMJG"));

        allQuestions.add(new Questions("Which desert is considered as the driest place on earth ?", "CMECIXSAAOTOARTYMA", "Atacama", "","QRSTCGO","LAAMAAK","LOGSRQK"));

        allQuestions.add(new Questions("What river runs through Baghdad ?", "LIGPTPIIRSOMJUISPO", "Tigris", "","ZSSTITL","ISGDRLR","TSDLZSRL"));

        allQuestions.add(new Questions("Lake Tahoe straddles the border between two U.S. states California & _______ .", "DAEZJMDYRQKVANGARA", "Nevada", "","ADRFIEX","DVANMXO","XXIFMROD"));

        allQuestions.add(new Questions("Japan’s Mt. _____ is  a pilgrimage site for centuries, it’s considered one of Japan’s 3 sacred mountains.", "NHCJQTUIFRBVAZSQAT", "Fuji", "","EAGFUJ","YFQMFI","QMYFEAGF"));

        allQuestions.add(new Questions("Kangchenjunga, also spelled Kanchenjunga is the third highest mountain in the world, and lies partly in ______ and India.", "YDMJNABLEVPEREBLAA", "Nepal", "","EDEPSP","QAMNFL","FPESMQD"));

        allQuestions.add(new Questions("Table Mountain is in which country ? ", "ACVROIFSUETVULJHGA", "South", "Africa","AAONSPCIT","HLEHFYRUC","PYCNEHL"));

        allQuestions.add(new Questions("What is the capital of Latvia ?", "LGXORCFRUUMCXCJZAI", "Riga", "","GRJNAA","RDMEIZ","MJAREZND"));

        allQuestions.add(new Questions("\"Durand Line\" is boundary between _______ and Afghanistan.", "AOHIFMALPKTZGRNBFS", "Pakistan", "","VAAHKRT","YRNIVPS","RHRYVV"));

        allQuestions.add(new Questions("The Hanging Gardens of Babylon was build during the reign of King Nebuchadnezzar for his wife. Where would the gardens be located today ?", "VVLTQTRCNIWUCMCAWV", "Iraq", "","ORLRIC","SYAFCQ","LCYFCOSR"));

        allQuestions.add(new Questions("Havana is capital of which country ?", "WKCFKEVICXAYUUKBLR", "Cuba", "","XEOVBA","UPQCJH","OXPHQVJE"));

        allQuestions.add(new Questions("The Radcliffe line is a boundary between _____ & Pakistan.", "CRSTAAGNIIAYHSLHDC", "INDIA", "","BYUZAD","NKIVIE","YZBKVUE"));

        allQuestions.add(new Questions("What is the capital of Malaysia ?", "PUMHPAAUOWKPRLUNRL", "Kuala", "Lumpur","RUKULAEMB","LHLUPYASK","LEKYBSH"));

        allQuestions.add(new Questions("What is the highest waterfall in Europe (Austria) ?", "OKXYSQOBGMAIRAMMVL", "Krimml", "","RSMMXTI","CLKLCVE","XLESVCCT"));

        allQuestions.add(new Questions("Mount _______ is the highest mountain in Canada and the second-highest peak in North America, after Denali. The mountain was named after Sir William Edmond Logan.", "PAXGHASGRMNSONYLWN", "Logan", "","GNTEIQ","AEPLNO","QPINTEE"));

        allQuestions.add(new Questions("Aconcagua is in which country ?", "SRNYFGABEGANTXKIIE", "Argentina", "","NBGAKNZJ","INEHZRAT","HZZNKBJ"));

        allQuestions.add(new Questions("Baalbek & Its Ruined Temples is located in which country ?", "CXBALNEOBQNMKHXISA", "Lebanon", "","YESDSEO","VLBNNVA","EDYVSVS"));

        allQuestions.add(new Questions("Yosemite National Park is located in which country?", "STESUTANEDSPTUJGAI", "United", "States","EKUSDTTNS","GTAPESVIR","RVPGSK"));

        allQuestions.add(new Questions("State Hermitage Museum is located in which city of Russia ?", "TBRUPGASIHRNEFTEKS", "Saint", "Petersburg","FUTRRGJIL","PASENTSBE","FLJ"));

        allQuestions.add(new Questions("What is the capital city of Cyprus ?", "CJCCAINOYCISYFHZOX", "Nicosia", "","SAPOVIC","INBSCIY","YICBVPS"));

        allQuestions.add(new Questions("Which African country used to be called Abyssinia ?", "IIQTAKDHYKOPEVTRTB", "Ethiopia", "","HOKIEUI","RTADWPK","KRWDKU"));

        allQuestions.add(new Questions("What U.S. state's official fish is the Humuhumunukunukuapua`a ?", "EITIYDUPMHWALRAARK", "Hawaii", "","RAICIHZ","AEDJXJW","DXZJJCRE"));

        allQuestions.add(new Questions("What is the capital of Turkey ?", "AHCAICNQHUVHOHAKKR", "Ankara", "","QKLKNLA","JJARTRA","KLJQJLRT"));


        //geography hard
        allQuestions.add(new Questions("What country occupies the southern end of the Arabian Peninsula ?", "GNRJQBEENUYAAZYMKY", "Yemen", "","GNCMYW","YNMEXE","NXWMGCY"));

        allQuestions.add(new Questions("Mount ________ (also known as Denali) is the highest mountain on the North American continent. Its summit is 20,237 feet (6,168 meters) above sea level.", "HRHSYQMEPYLZKMYINC", "McKinley", "","IMEHOBL","CNKYTZL","ZOBTLH"));

        allQuestions.add(new Questions("Mount ________ is the oldest active volcano on Earth ?", "ZRTGANEETKSWUJPRGL", "Etna", "","EOLATJ","HNJYEZ","JLEZOHJY"));

        allQuestions.add(new Questions("The national flag of what country has a white rectangular with a red disc in the center ?", "NAMKAAJHQVORPPJNAB", "JAPAN", "","LWAHGJ","PNTAAM","TMHGWLA"));

        allQuestions.add(new Questions("What is the capital of Chile ?", "AITYDIGSOLENXKAVNA", "Santiago", "","GIAATPH","SMYHONM","MYMHPH"));

        allQuestions.add(new Questions("What is the capital of Bosnia and Herzegovina ?", "OVURBEASDJAFBMWEXA", "Sarajevo", "","RVERHSJ","OEJARCA","RREHJC"));

        allQuestions.add(new Questions("Which Spanish Island is known as \"The Island of Eternal Spring\" ?", "UETWIERFENIGRUERBX", "Tenerife", "","IXETBAR","EEXNQFY","YBXXQA"));

        allQuestions.add(new Questions("What is the capital of Macedonia ?", "PJPYNPZOVOHSCFKPEA", "Skopje", "","JKOASJE","AQPSSPH","SQAPJAHS"));

        allQuestions.add(new Questions("3 countries do not use the metric system are _______, Myanmar and The United States", "IIEWBQLRIWCLVAASLR", "Liberia", "","GIDBRIZ","IAEBALB","BDABGIZ"));

        allQuestions.add(new Questions("Geelong is a port city located in what country ?", "ALBIUXGSKWAALRBTIM", "Australia", "","HNAACVLL","ZTUARSEI","ELVCZHN"));

        allQuestions.add(new Questions("What city is the capital of the country Turkey ?", "XYARKNSNFAQYIOWDAV", "Ankara", "","IGKRVFR","AAQBNBA","VBGBFIQR"));

        allQuestions.add(new Questions("In which state of the United States would you find Fort Knox ?", "EUOCKTJNNJFAHYYNKE", "Kentucky", "","OZTEKCM","NUIIKYC","IIMZOC"));

        allQuestions.add(new Questions("In what city would you find St.Peter's Basilica ?", "PIWAMXCBIBCANVDTGO", "Vatican", "","AVACTIA","AGBGDEN","ADAEBGG"));

        allQuestions.add(new Questions("\"_____ island\" is the name of the Spanish islands that lie off the Northwest coast of Africa.", "AICNBJQXVIERAKYACN", "Canary", "","NNNAQCR","OHWKHAY","OWNNKHQH"));

        allQuestions.add(new Questions("Madeira, an archipelago located in the Atlantic Ocean, is autonomous region of which country ?", "OSXUWLYHRCLGTPUDAM", "Portugal", "","TGUNARL","PPOVAGF","GVNPFA"));

        allQuestions.add(new Questions("Which state of the United States is the smallest ?", "QFBONEHRLDEAQHSDIM", "Rhode", "Island","IENIRSXHP","WVLAODDTN","IWVXTPN"));

        allQuestions.add(new Questions("What city is the capital of India ?", "NDMDFWHFUWGIKEELRZ", "New", "Delhi","EHWSDRN","EOLLHIM","MOSHLR"));

        allQuestions.add(new Questions("In what city in California was Disneyland opened ?", "AEMUHIIAKIYAACZRNK", " Anaheim", "","MEYFANA","YSOIOHP","POYOYFS"));

        allQuestions.add(new Questions("Frankenmuth, a U.S. city nicknamed \"Little Bavaria\", is located in what state ?", "NGMHSTGZWITCIDAJAH", "Michigan", "","EUHICXM","RIKNAIG","KUIXRE"));

        allQuestions.add(new Questions("What is the capital of Iceland ?", "KAIKTCLQTJEKRVVRYW", "Reykjavik", "","IRQAQVJJ","YFOKEWKD","JWQODQF"));

        allQuestions.add(new Questions("Canada is made up of how many provinces (in words)?", "NIOEETSUQXISOYRNWT", "ten", "","WTMZO","FDERN","FOMDWRZ"));

        allQuestions.add(new Questions("Valletta is the capital of what Mediterranean country ?", "TPLVAUMWLCELCWAQRU", "Malta", "","MLTLAX","RCAMZP","LRMXZCP"));

        allQuestions.add(new Questions("Asia Continent is \"__ __.__\" percent of earth area.", "856598765823149634", "29", "5","82659","87658","8687658"));

        allQuestions.add(new Questions("What is the capital of South Korea ?", "YLGSOWDXDEUVZHECCT", "Seoul", "","QOSLOE","UVGJSS","SJQGSVO"));

        allQuestions.add(new Questions("What is the capital of Nigeria ?", "ALFUJAWZAJRIXCHRBB", "Abuja", "","PUIWVB","JAXJAA","WXIVPJA"));

        allQuestions.add(new Questions("What is the flattest continent ?", "AUBLAZEDBTXAIRSDAU", "Australia", "","TRTRSLAO","UAQIAATL","RTATOQL"));

        allQuestions.add(new Questions("What is the largest country on the Arabian Peninsula ?", "FSIUBQAAAIWWXDRAJN", "Saudi", "Arabia","RINBDAIPI","WSMAIAUAY","PWYNIMI"));

        allQuestions.add(new Questions("What is the capital of Belarus ?", "NZSIRWSMOTSIUKZGKP", "Minsk", "","FSKNTQ","NRMRIU","RURTFNQ"));

        allQuestions.add(new Questions("In what state of US we can find Mount St. Helens mountain ?", "SLGIRNBFTMKONWHAYM", "Washington", "","HHOGTNAX","NNGWIWWS","XHWWNG"));

        allQuestions.add(new Questions("What is the capital of Kenya ?", "ETOXFICIBNRAIIAKGI", "Nairobi", "","DRIEBYR","BOIZAQN","ZRBEYQD"));

        allQuestions.add(new Questions("What Canadian province boasts the longest freshwater beach in the world ?", "MASSGWKAOAAPPOFBSX", "Wasaga", "","XPWSGRW","SNABAZA","WSNRPZBX"));

        allQuestions.add(new Questions("What state of US is as called the gem state ?", "ATQMRRIDYZHILLXQOC", "Idaho", "","LIYONH","AQDVGQ","QVLQGYN"));

        allQuestions.add(new Questions("What is the capital of Tajikistan ?", "HUSZVMDENQYDAANXBS", "Dushanbe", "","SUEHIGW","GUNBDAF","WUIGGF"));

        allQuestions.add(new Questions("What European capital is know as the \"Eternal city\" ?", "QMOMCCEJZORHBENTHQ", "ROME", "","RENXWK","IOAMMI","KMWAINIX"));

        allQuestions.add(new Questions("What is the capital of Lithuania ?", "WGVINOISZRUISSJHLK", "Vilnius", "","IUVAZON","QSUIYUL","UAUYQZO"));

        allQuestions.add(new Questions("Which river runs through the city of Paris ?", "XWNESAEIDNIIVNCOCU", "Seine", "","DIEUSE","IEELMN","LMEUIDE"));

        allQuestions.add(new Questions("What is the capital of Argentina ?", "UESUTZINIESRDNBAOQ", "Buenos", "Aires","VCNISWUSE","REBEOABEU","EVUBECW"));

        allQuestions.add(new Questions("Which European capital city is referred to as the \"The city of lights\" ?", "WRKIISAFKEPLEBKXBJ", "PARIS", "","IDOQPS","URAIBQ","DQOUQBI"));

        allQuestions.add(new Questions("Golden Temple is located in what city of India ?", "JATBZMKOLESRMIRDAA", "Amritsar", "","FTAACMT","RSREIDA","FATCDE"));

        allQuestions.add(new Questions("What is the capital of Iraq ?", "DRDYAHCZGTDNAGEFBJ", "Baghdad", "","ZGHGBAH","ZDGDYJA","HZGZJYG"));


        allQuestions.add(new Questions("What African country served as the setting for Tatooine in Star Wars ?", "JERIIALUOSSACKTAYN", "Tunisia", "","JSHJACI","XTINUAJ","HJJJCAX"));

        allQuestions.add(new Questions("What planet is often described as Earth's twin ?", "UZNNCJVTHAVFEAYNSS", "VENUS", "","UBEPUX","VSNQAF","QUXFPBA"));

        allQuestions.add(new Questions("Alaska and ______ became the 49th and 50th states of the USA only after world war two.", "SILRAANKAYPWAWHAGI", "Hawaii", "","RAHWYWO","RIHACID","RROYHCWD"));

        allQuestions.add(new Questions("What is the largest Greek island ?", "EOHCXUWEVRTBRKNNPG", "Crete", "","RSCVXD","TYRDEE","SDVDXYR"));

        allQuestions.add(new Questions("What country was known as siam ?", "GRHXDIATALNZWETAAB", "Thailand", "","ILTJHAN","EHANUDX","HJXEUN"));

        allQuestions.add(new Questions("How many total stripes are there on the flag of the USA ?", "185659876582314963", "13", "","1856598765","82314963","1856598765824963"));

        allQuestions.add(new Questions("What is the currency of Germany ?", "MUYPZEZLRNGSYCOZHD", "EURO", "","CBUWRO","SOEIFW","CBIOFWSW"));

        allQuestions.add(new Questions("In the basin of which ocean is the Ring of Fire Located ?", "YVPNFIHACUFIGNRCDH\n", "Pacific", "","IIPQSCF","AKHACCX","AXQCSHK"));

        allQuestions.add(new Questions("What was the Russian capital before Moscow ?", "RPNGRIUSTAOEEOTBPS", "Saint", "Petersburg","EDBENIRTT","BRGNAPSUS","BND"));

        allQuestions.add(new Questions("What is the longest river in Italy ?", "TPIFVAJRKVCIKHOQPW", "PO", "","OMCKXKPIR","VUEMWOIQC","EOKUCMCQXMIRWIVK"));

        allQuestions.add(new Questions("What language has the most native speaker in Europe ?", "DZKFWFLSFJFGUAENRM", "GERMAN", "","MWYAWNR","NMERJGO","MJRWYNWO"));

        allQuestions.add(new Questions("What sort of mythical animal is on the flag of the Wales ?", "SAJVIUIUXDMENGQORA", "dragon", "","RSDDAOK","UFEDOGN","UKEDDSOF"));

        allQuestions.add(new Questions("What island group does Tahiti belong to ?", "ACEEOSDHNLINPYFRSV", "French", "Polynesia","EACNNNFLS","PVHYRIEON","NNV"));

        allQuestions.add(new Questions("In what country would you find the city of Oslo ?", "ZJGNRHHVAGYOWVAFLC", "Norway", "","CWORWAQ","OASAZYN","ACWAQOZS"));

        allQuestions.add(new Questions("In what European capital is the Pantheon located ?", "EMJJSLORTHEWKOYLWV", "ROME", "","QAOTLM","ARXEAK","LXAKAQTA"));

        allQuestions.add(new Questions("What is the capital of Scotland ?", "RAUEBNFRXGHEUDUUIO", "Edinburgh", "","DERIUGNO","DUMZDIBH","ODDMZUI"));

        allQuestions.add(new Questions("What is currency of dubai called as ?", "HOYAOKRXDMYZIRXXAI", "dirham", "","IJMHHAR","PNDSWJE","JNWEPSJH"));

        allQuestions.add(new Questions("White and ______ colors appear on the national flag of Greece.", "LTJNFVENIUTYYVTQBC", "BLUE", "","MLWSBS","RJEUBT","JSMTSBRW"));

        allQuestions.add(new Questions("What is largest island in the world ?", "GCWNNDNGRAAMELEERC", "Greenland", "","DDERZENL","OZGALNPH","ZOLPZHD"));

        allQuestions.add(new Questions("_______ city is the capital city of Nevada state.", "SCVNQSNFWHOUAPRYCL", "Carson", "","ONQCOGA","SYSKXUR","UXSOQYGK"));

        allQuestions.add(new Questions("What country is also known as Persia ?", "KAIUTKASHGPQTRGNYJ", "IRAN", "","AYLXRW","NIBUWF","WYLXWBUF"));

        allQuestions.add(new Questions("Which country has 11 official language ?", "FTDAOIRCWHASRUUJCH", "South", "Africa","TFBXSKORI","CURAHKAUI","IBKXKUR"));

        allQuestions.add(new Questions("Which country has border with Brazil, Paraguay and peru ?", "IKDBLLYLVACVIAPOIV", "BOLIVIA", "","LPKBQIQ","NAFVIOG","PQFGQNK"));

        allQuestions.add(new Questions("What is the smallest country of european union ?", "DMMXAPWOLYMOHATKZW", "Malta", "","CMGLGP","TZAPAK","GCZPKPG"));

        allQuestions.add(new Questions("Which of Earth's oceans holds the most water ?", "GSAPCXFTPFVGGCAIID", "PACIFIC", "","PIECMCA","PEVIPFI","IEMVEPP"));

        allQuestions.add(new Questions("What is the capital city of New York state in the USA ?", "LEKVQIFLYJBZANLAPT", "ALBANY", "","YXBKLNE","YYAAYPO","YPKYEXYO"));

        allQuestions.add(new Questions("What is the currency of china ?", "NKIGUNVHIBMNEBARYR", "Renminbi", "","VIMBIXH","KUNERZN","VUHXZK"));

        allQuestions.add(new Questions("In what country is Marseille ?", "NFNOAZNCOFQUFIRJSE", "France", "","ESRAFYG","RHOCCNZ","OYZHSRGC"));

        allQuestions.add(new Questions("Sagrada Família a Roman Catholic church is located in what city of Spain ?", "MLWWRMJENBCNPAOEXA", "Barcelona", "","NEKVEYBA","SOLAHCRN","VHNKSEY"));

        allQuestions.add(new Questions("What country does Easter island belong to ?", "HXDKLCEQJPFIKTTPHR", "CHILE", "","QFHCUL","IERPWI","UWRPFQI"));

        allQuestions.add(new Questions("What country do the Galapagos islands belong to ?", "KACRSRAUKUCEOFDGDZ", "Ecuador", "","UCPFDAG","AOERQEA","EAAGFPQ"));

        allQuestions.add(new Questions("The flag of Italy is a tricolour featuring three equally sized vertical pales of (from left) _______, white and ___.", "IDWWREFDWMBIUKIEHT", "white", "red","DWTXHRE","LDGKIEQ","QKDXLG"));

        allQuestions.add(new Questions("Qatari ______ is the currency used in Qatar.", "XONLMVKACIYRRLBDIP", "riyal", "","NRCOBY","WLYICA","WNCBCYO"));

        allQuestions.add(new Questions("How many stars are there on the flag of Singapore ?", "OOFUIDETERNNLBVISF", "five", "","YUBIFO","DVVERI","VIYBODRU"));

        allQuestions.add(new Questions("Capital city of Arizona state (USA) ?", "ZPNHGTGMPXMIHHAXOE", "Phoenix", "","INWFDYE","XFOHPON","NFWDOFY"));

        allQuestions.add(new Questions("What is the fifth planet from the sun ?", "SIHQADNPRHUUSJTQIE", "JUPITER", "","RSTPEGG","JINBUJO","OJSNBGG"));

        allQuestions.add(new Questions("Atmospheric pressure is measured by which instrument ?", "LERJTWVSPZNAROCEBM", "barometer", "","EABMTERT","WWRTOIFE","FWITWET"));

        allQuestions.add(new Questions("What is the Earth's only permanent natural satellite ?", "BIOXKKUQWGRYVMTNKO", "MOON", "","ASNOEC","WMUOJO","CWUOSJAE"));

        allQuestions.add(new Questions("The ______, is a megatall skyscraper and highest skyscraper in the world located in dubai, United Arab Emirates.", "IAUHRSKRQLDFABLJFI", "Burj", "Khalifa","BZALSIJZS","UHWRKFAJB","BSWZSZJ"));

        allQuestions.add(new Questions("Olympus Mons is a very large volcanic mountain on which planet ?", "RJAICMOAMYMEUEECSX", "MARS", "","UNSWMV","FJAXAR","VXJWAFUN"));


     //Science easy
        allQuestions.add(new Questions("Which chemical element is represented by the symbol Au ?", "PDITQGZCOGBOLPOBBJ", "GOLD", "","AGLDVB","AUTOPT","PAVATUTB"));

        allQuestions.add(new Questions("What material forms the hard outermost layer of a human tooth ?", "FNWAALNGVQERQJOEAM", "Enamel", "","IEMEGXL","BDNZATA","ZXDGBITA"));

        allQuestions.add(new Questions("How many sides does a rhombus have ?", "485659876582314963", "4", "","485659876","658231496","85659876658231496"));

        allQuestions.add(new Questions("How many electrons are there in an atom of Helium (in words)?", "DIWAUNTHSNOMGDOZPK", "TWO", "","BTOPW","CORWU","WCPRUOB"));

        allQuestions.add(new Questions("What does the 'P' stand for in the acronym CPU ?", "GRSOKCZIPTXXISENNY", "PROCESSING", "","GCIXNORT","OSEPQCSS","QXOSCT"));

        allQuestions.add(new Questions("Which is the most abundant metal in the earth's crust ?", "AMYUQJUIQXAWTLMMNR", "Aluminum", "","NLUMFVN","IAUXNCM","FNVXNC"));

        allQuestions.add(new Questions("__°F is the melting point of ice in Fahrenheit.", "356598765823149632", "32", "","356598765","823149632","3565987658231496"));

        allQuestions.add(new Questions("\"NASA\" stand for \"______ Aeronautics and _____ Administration.\" ", "PTAECFJLOPRASANIBN", "National", "Space","NATPDMPAI","SOAYECNAL","PADMY"));

        allQuestions.add(new Questions("Meter, Liter & _____ are the three base units of measurement in the metric system.", "BMMBZRSVNRGFSMORAP", "GRAM", "","HRMARI","JIIIGW","WHRIIIJI"));

        allQuestions.add(new Questions("What is the largest internal organ of the human body ?", "ROTFXEKGZUIETIMLJV", "Liver", "","VXRYEV","CLMVIS","VSXCVMY"));

        allQuestions.add(new Questions("What was the name of the first U.S. space station ?", "KAAAKGYSLGWMBKBZNI", "Skylab", "","POGLYAB","BYQKHFS","YFHGBOPQ"));

        allQuestions.add(new Questions("What is the largest 3-digit prime number ?", "995987658231496397", "997", "","99598","96397","5989639"));

        allQuestions.add(new Questions("What vitamin is produced when a person is exposed to sunlight ?", "DAAAKGYSLGWMBKBZNI", "D", "","CGFHZBDHD","DVKUXYAHY","KCVDHABUHZXFHYGDY"));

        allQuestions.add(new Questions("What is the name for a protein that acts as a biological catalyst ?", "BSTVMZESJAYVNELQUC", "Enzyme", "","EZNKQZE","ZMUABEY","KBEZQUAZ"));

        allQuestions.add(new Questions("Which planet in our solar system has the most oxygen ?", "JAHDREEYUWHLWTOEHH", "Earth", "","ENHDUR","TOAHNA","NUHADNO"));

        allQuestions.add(new Questions("Callisto is the name of a moon orbiting what planet in our solar system ?", "ZIPTLJTPVJUEFSEYXR", "Jupiter", "","JDHNIRE","PQUNFJT","FQJNDNH"));

        allQuestions.add(new Questions("Fe is the chemical symbol for what element ?", "NPTURQHIBTROFGPUKR", "Iron", "","ONMCOF","QOIRZR","CFQORMZO"));

        allQuestions.add(new Questions("The filament in an incandescent light bulb is made of what element ?", "XDMAXETNNSNZFGXDTU", "Tungsten", "","GTPWSNN","UHTUESE","PEUWHS"));

        allQuestions.add(new Questions("In what month is the longest day in the Northern Hemisphere ?", "DKFUVLVVWRENQJTJHL", "June", "","TPYKJU","PBENJB","PTJYPKBB"));

        allQuestions.add(new Questions("The European Organization for Nuclear Research is known by what four letter acronym ?", "RMKNEKMZLNHCARFJVI", "CERN", "","EEDFKL","NRCPYZ","ZEDYFKLP"));


        allQuestions.add(new Questions("O3 is a chemical formula for ?", "NWERWGHLOOZNHPNMCP", "OZONE", "","LGQYOU","NMEOOZ","GOYULMQ"));

        allQuestions.add(new Questions("What is the smallest planet in our solar system ?", "CRKCTZYTEGVRYMUUVP", "Mercury", "","TCMRRUY","MHBRESU","UBSTHMR"));

        allQuestions.add(new Questions("How many acres are in a square mile ?", "645987658231496370", "640", "","94340","87658","9438758"));

        allQuestions.add(new Questions("What does the chemical symbol Fe2O3 represent ?", "NEDIRWTNWIPXWOKWOX", "Iron", "oxide","LOZDEYII","OFEERNXN","FZELYNE"));

        allQuestions.add(new Questions("Chemical formula for water is ?", "N3M5KVB82RHO2HAHFT", "H2O", "","S2L4O","B2UHG","2UBG4LS"));

        allQuestions.add(new Questions("The gas usually filled in the electric bulb is ?", "CYJNSSERQIRNGAOTDI", "Nitrogen", "","EGKQNWV","IGOITNR","KGIWVQ"));

        allQuestions.add(new Questions("Washing soda is the common name for ?", "OETRNTODBSAUAGZCIM", "Sodium", "carbonate","ACFPNBDOA","RQMUESTOI","QPF"));

        allQuestions.add(new Questions("What is laughing gas commonly known as ?", "ONIOBMOSUMXTIERDNU", "Nitrous", "Oxide","IBXTTIINO","DOEUZRBSC","TZBBCI"));

        allQuestions.add(new Questions("What is the chemical equation for hydrogen peroxide ?", "N3M5KVB82RHO2HAHFT", "H2O2", "","X5OE2P","SH4PS2","54PPXSSE"));

        allQuestions.add(new Questions("Diamond is an allotropic form of ?", "INAHPRCYOBHNKOOFYH", "Carbon", "","NCBJIXA","FPRFSOR","RIFSPJXF"));

        allQuestions.add(new Questions("_____ is a chemical compound with the chemical formula CH₄ & main constituent of natural gas.", "TKEPINFMRWDHMEFYWA", "Methane", "","OTQNMEP","AFWEEHQ","QPFQWOE"));

        allQuestions.add(new Questions("A magnifying glass is what type of lens ?", "BMJTJOBXGNVAPECUEY", "Convex", "","EXKUBNJ","CVIONOC","BCONUIJK"));

        allQuestions.add(new Questions("Earth is located in which galaxy ?", "HQYTQGIVLDWWHKAYMQ", "Milky", "Way","EWDLYTM","KUILAYI","EUTIDL"));

        allQuestions.add(new Questions("Electric current is typically measured in what units ?", "SRHQREEAPKIYRTXMCD", "Amperes", "","EBABZSM","AIPRGBE","BBABGZI"));

        allQuestions.add(new Questions("After whom the Hubble Space Telescope named ?", "UUDEDELBJIHWABHJNB", "Edwin", "Hubble","GPDNEKHIB","SOWELBIUE","IPKSGEO"));

        allQuestions.add(new Questions("Animals which eat both plants and other animals are known as what ?", "VNSSEORJSRIQOYQLXM", "Omnivores", "","EQOAONMV","VSKWIORH","KVWQOAH"));

        allQuestions.add(new Questions("A single piece of coiled DNA is known as a ?", "OZXCEMMEROHCESOHUV", "Chromosome", "","HXCMROEN","MOOIGMSL","LXNGMI"));

        allQuestions.add(new Questions("In terms of computing, ROM stand for \"_____ ONLY _____\".", "YOIYJAMMRMXHDZPERE", "READ", "MEMORY","MKEDCRKF","RTDOEAMY","CFKTKD"));

        allQuestions.add(new Questions("The abbreviation WWW in internet stand for \"_____ _____ WEB\".", "ETYODIDADWRWTLIXLH", "WORLD", "WIDE","DRCEGWZL","SDOSOWIE","CZSGESO"));

        allQuestions.add(new Questions("Electric power is typically measured in what units ?", "DTPQSHJWQQWOAZVWMT", "Watts", "","TAFUWY","ZSYFTC","UYCFZFY"));


        allQuestions.add(new Questions("What is the name of the force holding us to the Earth (noun) ?", "FVILITGANTYYRQVWSR", "Gravity", "","ZAIGGRV","WYLRRTH","ZWRLRHG"));

        allQuestions.add(new Questions("What planet is famous for the beautiful rings that surround it?", "JCTRVWHUMSWNCKLBAE", "Saturn", "","RSNNLTI","NAYYUTE","NELTIYYN"));

        allQuestions.add(new Questions("which is the coldest planet in our  solar system ?", "UFNBPETPENDVEJPETU", "Neptune", "","UGEEPUN","NTTGNIR","GNTIRGU"));

        allQuestions.add(new Questions("What is the first biggest planet in the solar system ?", "TJIUYGQYIOXREPRNNV", "Jupiter", "","EJTBERJ","UKDJPEI","EKJBEJD"));

        allQuestions.add(new Questions("What is the name of the first satellite sent into space ?", "UKCBGTINIESCDPSWDC", "Sputnik", "","TOPQRUK","DSKIPFN","KPRQFOD"));

        allQuestions.add(new Questions("Bell metal is an alloy of ____ and copper.", "XTMTAAXOXJEBMPNTIN", "TIN", "","WTMKU","ZUNIE","UEKUWZM"));

        allQuestions.add(new Questions("Non stick cooking utensils are coated with ?", "OWNFSNAEIBTWYUIFEL", "Teflon", "","LZKXLOL","NTYFEGV","GLZVKXLY"));

        allQuestions.add(new Questions("Electric resistance is typically measured in what units ?", "BYSUOUVMHFDTUIBUMG", "Ohms", "","MLSAGH","TOMMEM","GTMAMLEM"));

        allQuestions.add(new Questions("What is the name of the process used by plants to convert sunlight into food ?", "NECHSEOIPYODTTSHHS", "Photo", "synthesis","LUOTOHSYM","HNITBPSSE","LBUM"));

        allQuestions.add(new Questions("What is the name of Saturn’s largest moon ?", "YYHAGYJUTGBNTIXZSA", "Titan", "","MPTSAA","TWNKIO","MPSKAOW"));

        allQuestions.add(new Questions("How many moons does the planet Venus have (in words) ?", "EIROZPHUPEKGDLVZMX", "ZERO", "","RDEZTR","WOJOMG","TJWGDROM"));

        allQuestions.add(new Questions("What is the force that opposes the relative motion of two bodies that are in contact ?", "FICIIBONROITRFICTN", "Friction", "","IINNXMC","FRNDYOT","MXDNYN"));

        allQuestions.add(new Questions("What blood type do you need to be a universal donor ?", "OEIROZPHUPEKGDLVZM", "O", "","UPXLENORC","JFRDNHOZZ","HPZLRFCNNEJXOUDRZ"));

        allQuestions.add(new Questions("In our solar system two planets rotate clockwise Venus & ______.", "TYSIUFCAULUCRUEOSN", "Uranus", "","UNRZUVT","TXUAUSO","UXZVTUTO"));

        allQuestions.add(new Questions("Rubies and sapphires are both made of what rock-forming mineral ?", "VLCPOUASZLIRMNUUJD", "Corundum", "","TOHDMMU","UNCHBRQ","QBMHTH"));

        allQuestions.add(new Questions("According to Mohs scale, what mineral is the hardest ?", "NMGLIPDDOBAYEDVZRA", "Diamond", "","TIMOMND","NKDZBAD","DNMBKZT"));

        allQuestions.add(new Questions("At minus __ degrees temperature Celsius and Fahrenheit equal.", "456598765823149630", "40", "","456598765","823149630","5659876582314963"));

        allQuestions.add(new Questions("Which elements symbol is the letter K on the periodic table ?", "MQTSAEPBKFOBPUOIMS", "Potassium", "","CCOPTSPI","LSNDAMUA","LNDCPCA"));

        allQuestions.add(new Questions("Which part of the eye gives it color ?", "NHJSFVIJRGGSXTIXIZ", "Iris", "","RPLDII","XMMSWI","PIWDXMML"));

        allQuestions.add(new Questions("Which is the largest of Mars' two moons ?", "XMRMLLSBRBOHIOPZKO", "Phobos", "","QERIYRS","BOFOPEH","IRERYQEF"));


        //science medium
        allQuestions.add(new Questions("1 dozen equals how much (number)?", "185659876582314962", "12", "","185659876","582314962","8565987658231496"));

        allQuestions.add(new Questions("meters (m) is SI unit of measurement of what ?", "TTUMLLLCGHIORCNAEL", "LENGTH", "","GLINEOS","GHERCXT","RGOSCXIE"));

        allQuestions.add(new Questions("Which part of the eye gets smaller when the lights go on ?", "XNPYLIWMHJWDPGDZHU", "Pupil", "","IPVIPP","NUKLGI","NIKVIPG"));

        allQuestions.add(new Questions("What kind of energy is stored in batteries ?", "CBRIFCFLRMTTSEYCHA", "Chemical", "","EEIHLVC","OOXATMC","XOTOEV"));

        allQuestions.add(new Questions("The formula for calculating speed is ______ divided by _____ .", "NETIEIITMHHCASDPTE", "DISTANCE", "TIME","IDTNTTETN","AESSDMQCI","STTQDN"));

        allQuestions.add(new Questions("What are the materials that do not conduct electricity called as ?", "OSGDSISLNRTUITALPC", "INSULATORS", "","TLVWIFSF","RNOIJSAU","WJIFFV"));

        allQuestions.add(new Questions("What temperature Fahrenheit does water boil at (sea level) ?", "215987658231496372", "212", "","21598","96372","5989637"));

        allQuestions.add(new Questions("What is the scientific study of fungi called as ?", "LOOMYROCZYSFGQTGVF", "MYCOLOGY", "","OLTGCDO","MJYYPCM","PCJMTD"));

        allQuestions.add(new Questions("Path followed by an electric current called as ?", "MRIOCCEPTVIFEHHWUC", "circuit", "","BITCCUR","IBNKAIB","ABKBNBI"));

        allQuestions.add(new Questions("What is the unit for measuring the amplitude of a sound ?", "RECRRMDIIECLTJBYVX", "DECIBEL", "","KIYDLBW","LEVECAX","WYAXVLK"));

        allQuestions.add(new Questions("A chronometer measures what ?", "IIHXMEVTGMCJXUVXRN", "TIME", "","TIEQZR","TXQJMW","ZQJQXTWR"));

        allQuestions.add(new Questions("What is the second most abundant element in the earth's atmosphere ?", "AXDQYGEOUNFDYBUZGA", "Oxygen", "","NEONISG","ZXHRSYG","NSHRZISG"));

        allQuestions.add(new Questions("_____ is a car-sized rover that was launched by NASA in 2011 to explore mars.", "SRGFEIUTQYOECJWQOI", "Curiosity", "","ZSRTITOI","ULXYERCW","ZRWXTLE"));

        allQuestions.add(new Questions("Who designed and built the Pascaline ?", "PPNISCLABAEASLIFRE", "Blaise", "Pascaline","RPSSALNCE","IUDELIABA","RUD"));

        allQuestions.add(new Questions("What is the medical term for bad breath ?", "SIVILAVOTRLNSHSHHZ", "Halitosis", "","ILNSEFSJ","ISOAHSTK","SSEKFJN"));

        allQuestions.add(new Questions("Mercury and ______ are two elements on the periodic table that are liquids at room temperature.", "EOPNHNBVSMQRAPIPRV", "Bromine", "","URRKBWE","UBIENOM","UUREWBK"));

        allQuestions.add(new Questions("Which is the closest galaxy to the milky way ?", "FXDLDAOAFUEDRTUMDN", "Andromeda", "","RDYOAMLB","EZRANNDL","LRNLZYB"));

        allQuestions.add(new Questions("What is the third most abundant gas in Earth's atmosphere ?", "YASMGYDUJQGARJMONA", "Argon", "","YRAOWB","BZNFLG","WZLBBYF"));

        allQuestions.add(new Questions("Who is considered the father of psychoanalysis ?", "LIUNESHDGUSWFDFCRM", "Sigmund", "Freud","DMGRNUNMG","SGFEQDIUF","FMGNQG"));

        allQuestions.add(new Questions("What is the largest external organ of the human body ?", "IGKFATYCSYBOKAGNGY", "Skin", "","DKCSIE","XEQSNB","XCESQEBD"));


        allQuestions.add(new Questions("chemical formula for sodium chloride/salt ?", "NEHLIZACMMLBIVLGKV", "NACL", "","PQVGAL","NVCZEO","VPVQOZGE"));

        allQuestions.add(new Questions("How many feet are in a mile ?", "526598765823149680", "5280", "","526598","149680","65981496"));

        allQuestions.add(new Questions("What is known as the \"master gland\" of the human body ?", "AIPIRPOINYUNTWSTJY", "pituitary", "","MTJUVAVY","LPKIPIRT","LPKMJVV"));

        allQuestions.add(new Questions("Who is generally acknowledged as the “father” of the modern periodic table (full name)?", "RFEGMVIEIENETMDDWL", "Dmitri", "Mendeleev","EMYIDEVJL","MDENETIRI","IJY"));

        allQuestions.add(new Questions("Aspirin comes from the bark of what tree ?", "DBWQOLGQNZLRGHTCIW", "willow", "","YCYOMWW","IWXCLPL","MYWPYCXC"));

        allQuestions.add(new Questions("At ___ mph wind speed a tropical storm become a hurricane.", "765987658231496374", "74", "","765987658","231496374","6598765823149637"));

        allQuestions.add(new Questions("Who is honored as Father of Modern Chemistry ?", "SOEVRETSNLCOIANAII", "Antoine", "Lavoisier","EOATNWHVE","RINLSIOIA","HW"));

        allQuestions.add(new Questions("______ dioxide & Nitrogen oxides gases cause acid rain.", "XUUXUSPRLEECKHIDWP", "Sulphur", "","SHDMRUY","APLUCUV","MYADVCU"));

        allQuestions.add(new Questions("Which element is used in the making of microchips ?", "ZIONKOOISHLCQIOQPI", "Silicon", "","MNOICQB","LIIRSGQ","QIMGBQR"));

        allQuestions.add(new Questions("What is the chemical formula of ‘Sodium Hydroxide’ ?", "JOJURKWLKNAKYIGQJH", "NAOH", "","BXOPJX","UANNHD","UXBJXDNP"));

        allQuestions.add(new Questions("Loudness of sound depends upon ______ of sound wave.", "JESLXPOMJPDUAITMII", "Amplitude", "","HEWTULAT","GDEGMIGP","TWGGGEH"));

        allQuestions.add(new Questions("The fourth state of matter is know as ?", "IPSLAUFZYARMMFDASV", "PLASMA", "","RHNLAPA","ARVMSLH","LHHNRAVR"));

        allQuestions.add(new Questions("The time period of a seconds pendulum is ____ seconds.", "WTOZKKLXQQSGAFFPJH", "TWO", "","POAJI","OGFTW","JOPAGFI"));

        allQuestions.add(new Questions("A condition in which close objects appear clearly, but far ones don't. is called as Nearsighted OR _______.", "YYQVEPAIOIAXOXMPMF", "MYOPIA", "","OILAYPM","ITKCSLW","TISKCWLL"));

        allQuestions.add(new Questions("In photocell light energy is converted to ______ energy.", "UARWSETIIGWLZCCCEF", "ELECTRIC", "","ETCLGPL","RCCIEHW","LGPHCW"));

        allQuestions.add(new Questions("What is the 7th element on the periodic table of elements ?", "GRJNJARVAQCITOGNVE", "Nitrogen", "","WVOEIRR","NJOLTGN","VLWOJR"));

        allQuestions.add(new Questions("In what type of matter are atoms most tightly packed ?", "JLIOHAZWTWJTSDOWVB", "SOLID", "","IEROKP","LDNDSH","NEKDHRP"));

        allQuestions.add(new Questions("What instrument is used to measure wind speed ?", "BNAOXTMEEBRQVVMEBA", "anemometer", "","AEMREVWZ","EYTMZNIO","WZIVZY"));

        allQuestions.add(new Questions("Ag is the symbol for ______ ?", "IAJHFRSLDSMZVMTINE", "SILVER", "","FWLCASI","RKRVESA","RAKSCAFW"));

        allQuestions.add(new Questions("CH3COOH is chemical formula for ______ acid ?", "FFGAITHICTOEECCYRC", "Acetic", "","IAXETCK","MDYIECB","IKEBMDXY"));


        allQuestions.add(new Questions("Newton's third law:\nEvery action has an equal and opposite ______.", "OOINTWURRFAZCUUOEB", "reaction", "","SOLCITF","EEAERNY","LEYSEF"));

        allQuestions.add(new Questions("What is the term used to denote the tendency of an object to remain in a state of rest until acted upon by an external force ?", "IIEEENTRMJJWMAAUNE", "Inertia", "","TCVREOI","RAILXGN","OCGVXRL"));

        allQuestions.add(new Questions("Cl is the symbol for which element in periodic table ?", "OCIPAHJSEOPELLNARR", "Chlorine", "","ERLHOIX","OSBCNML","BOLSXM"));

        allQuestions.add(new Questions("What is measured by the SI unit called a 'henry' ?", "TNICESSUMVIDUACNVW", "Inductance", "","NUDSEINV","XNTJBCAC","XBVJSN"));

        allQuestions.add(new Questions("Which French chemist gave oxygen its name and proved that water was a compound of oxygen and hydrogen ?", "EAVVSHCOIRDILMVOHL", "Lavoisier", "","SEIIEEOU","LOAXQVVR","XQVUEEO"));

        allQuestions.add(new Questions("What is the ability of fluids to offer resistance to flow ?", "OZTIYCWBYISCVPMSCI", "Viscosity", "","XIYTJVSR","LHSEOTIC","TELRXHJ"));

        allQuestions.add(new Questions("Which element has atomic number 9 in periodic table ?", "IYWEJNFLFHJLODUFRH", "Fluorine", "","NOLWRML","EOJPFUI","POMJWL"));

        allQuestions.add(new Questions("Bauxite is the ore of which element ?", "IRMMHILUUEXANNEYTX", "Aluminum", "","ILMAMFU","IHUACPN","CFHPAI"));

        allQuestions.add(new Questions("Which element has atomic number 18 in periodic table ?", "TLUZDAJFMFMGPWRONL", "Argon", "","RRNTAC","GDDOTN","RDTCDTN"));

        allQuestions.add(new Questions("Which electronic device magnifies the strength of a signal ?", "OFIMMIIMRDEUAHMLRP", "Amplifier", "","WPOIIVOR","SYAMLEDF","DOVWYSO"));

        allQuestions.add(new Questions("Which element has atomic number 10 in periodic table ?", "ULXNWLEFJGRGENALOC", "Neon", "","KNNPHZ","OERIJN","PRZIKJHN"));

        allQuestions.add(new Questions("What is a cylindrical coil of wire in which a magnetic field is created when an electric current is passed though it ?", "IOLNNYISQDORWIQLEI", "Solenoid", "","OERNSIL","PCOEPDR","CRERPP"));

        allQuestions.add(new Questions("Mg is the symbol for which element in periodic table ?", "MIFLDSTAXABGUMRENC", "Magnesium", "","VIFOZEMS","MNUAGXYM","ZVOXMFY"));

        allQuestions.add(new Questions("What is the SI unit of magnetic flux density, named after a Croatian electrical engineer ?", "WUISXBELWTAGJRAKAE", "Tesla", "","EAWSFY","NMLETR","FEYWRNM"));

        allQuestions.add(new Questions("B is the symbol for which element in periodic table ?", "IMIIAFOYORFFBRNMLY", "Boron", "","BPROLM","DNOQRT","TQMPDLR"));

        allQuestions.add(new Questions("Kr is the symbol for which element in periodic table ?", "TNTCYKETYKTVOFHPRZ", "Krypton", "","KNROJYT","GBKUCPN","JNBCGUK"));

        allQuestions.add(new Questions("What is the product of the mass of a body and its linear velocity ?", "WNVNCMTTOMENLMMHUM", "Momentum", "","EMOTDMM","PQKNMUX","PMDQKX"));

        allQuestions.add(new Questions("What can be expressed as the number of cycles of a vibration occurring per unit of time ?", "TEZQNEURFCIYWEFSQN", "Frequency", "","OQNEPYTM","CFEUERUC","POTUEMC"));

        allQuestions.add(new Questions("Rusting produces which material ?", "DWYXIKEONRCIGDDXEO", "Iron", "Oxide","DCDXGIJO","IOWINMER","CJMGWDI"));

        allQuestions.add(new Questions("Which element has atomic number 29 in periodic table ?", "CPDQBGAPFJEJMORYZI", "Copper", "","JWASERP","OGLCPJZ","JZAGJWLS"));


          //science hard
        allQuestions.add(new Questions("Which polymer is used to manufacture electric switches, computer disks etc ?", "LEBIBQFUPKPIBAEEUT", "Bakelite", "","RELGIKB","EYLPTCA","PYGLRC"));

        allQuestions.add(new Questions("What is the chemical formula of baking soda ?", "23TA3AFTHCHONERCTH", "NaHCO3", "","65EHHY3","3WCFOAN","FY35EW6H"));

        allQuestions.add(new Questions("What is the solvent of gold ?", "UAQACQIEARJIKQGIAL", "Aqua", "regia","RAACVUIT","GQEABVAU","BAUVTCV"));

        allQuestions.add(new Questions("Which chemical is called Chile Salt peter ?", "USNANMWEDRSTTOIIXC", "Sodium", "Nitrate","TOTSQDUZT","RMINATMIE","TMTZQ"));

        allQuestions.add(new Questions("Which is the simplest sugar ?", "PYOKGUSCGCTMKLKZES", "Glucose", "","GLUPECR","LRSDGOU","RGLDURP"));

        allQuestions.add(new Questions("Vitamin A is also known as ?", "LHCTTNEEKQIOOLZYOR", "retinol", "","EWLIOGJ","RTNBBQR","QRGJWBB"));

        allQuestions.add(new Questions("The hydraulic press is depend upon ______'s principle.", "QQEALXJGBFIAPECSVS", "PASCAL", "","LAALMKZ","PCPUSQC","UPQZKMLC"));

        allQuestions.add(new Questions("The Newton's first law is also referred to as \n\"Law of _______\".", "INNHDFMIYAESXAJTRR", "inertia", "","LVTZITE","EBARRNI","ZELVBRT"));

        allQuestions.add(new Questions("Vitamin B1, also called as ?", "HRIMEZMJNIDZATZCLO", "thiamine", "","EIXTPHD","AIYMNPY","DXPYPY"));

        allQuestions.add(new Questions("Which instrument is used to measure atmospheric humidity ?", "UGDEHOMEYRIXJTQGRE", "hygrometer", "","TRYRHXTG","KMHOPUEE","PXUHKT"));

        allQuestions.add(new Questions("Pollution of water bodies by which element causes Minamata disease ?", "WHUAYMJKRSHJMCCERU", "Mercury", "","TEURYRU","TMTZCKU","UTKTZUT"));

        allQuestions.add(new Questions("SI unit of electric charge is _______(C).", "COVFBXLTDUMYFMOQLF", "coulomb", "","OAIBMLY","OSCELRU","YRIALES"));

        allQuestions.add(new Questions("The field produced around the current carrying conductor is ?", "NACTIHHBGGASRCMEOM", "magnetic", "","THCGENI","AMLUDCR","DRLUCH"));

        allQuestions.add(new Questions("Which type of mirror is used in the head light of vehicles ?", "NVAJFEGDCIOJJURBCW", "CONCAVE", "","NNKZCAR","COQOVAE","KAOQZNR"));

        allQuestions.add(new Questions("What is the thinnest layer of the Earth ?", "RSMAFCEJTATDPCTUCW", "crust", "","RLUTOC","SYCRUH","ORYHUCL"));

        allQuestions.add(new Questions("One ______ is the standard unit of kinetic energy.", "HLSSIJZBLVEYRGNOZU", "joule", "","JXEBLC","OIQZWU","BCWIQXZ"));

        allQuestions.add(new Questions("What percent of the Universe is visible (in words)?", "MOWRBBJREUCRRWIGFI", "FOUR", "","GUWFFV","RQQWNO","WGNWVQFQ"));

        allQuestions.add(new Questions("What color is on the outside arc of a rainbow ?", "VBDVEAQCRDOFJBTBKU", "RED", "","ARSRB","DHDEA","ABHARSD"));

        allQuestions.add(new Questions("What is the energy an object possesses due to its motion ?", "KNCJEGIIYMEFKZLTFJ", "Kinetic", "","TMKEFIX","AFCGNIE","GMEXFAF"));

        allQuestions.add(new Questions("Which chemical element is named after the creator of dynamite ?", "SVLNUHEOSFMBXJLEIN", "Nobelium", "","YEUNLOB","GAIUMEM","AEMYGU"));


        allQuestions.add(new Questions("The most abundant metal in the Earth's crust is ?", "NUAUPVUQMNGIKMRSLD", "aluminum", "","TLFTIMV","ARTMNUU","TTTRVF"));

        allQuestions.add(new Questions("The lightest metallic element floats on water is ?", "QQJIMHTLTULHITBLUN", "lithium", "","IUXLRGL","IHMTTIH","IGTXLHR"));

        allQuestions.add(new Questions("The only element in the halide family that is a liquid at room temperature and pressure is ?", "EYTONOUNNEBLOIDRMR", "Bromine", "","IOORNRM","BVNEWDI","VROINDW"));

        allQuestions.add(new Questions("Ra is the symbol for which element in periodic table ?", "BDFIMUCAQRVAMWUYVG", "Radium", "","IZXJMDM","RIKUALG","KGLJMIZX"));

        allQuestions.add(new Questions("The most reactive family of metals is the ______ Metals.", "BGADARSRLLLMJKILAE", "alkali", "","VLLOAKL","QNIUAAY","OUNYQVAL"));

        allQuestions.add(new Questions("What is any material that allows the passage of electricity and heat called ?", "DCAURBBIGCTQNOOCBC", "Conductor", "","GITZDROR","NLQZOCUC","ZGQRLIZ"));

        allQuestions.add(new Questions("What word defines sounds too low for human hearing ?", "KIICHRAQONNTIHFSPV", "Infrasonic", "","IRVBOFYW","SOPNCIAN","PVBOWY"));

        allQuestions.add(new Questions("How many periods are on the periodic table (in words)?", "LEVSNEHGEEBHEIDTRT", "SEVEN", "","XXNACS","BVZEHE","XXHBACZ"));

        allQuestions.add(new Questions("What was the first synthetic plastic ?", "KEVLRGEPFTQBITAEOJ", "Bakelite", "","MVBEQJA","EFTIKLR","MFQVJR"));

        allQuestions.add(new Questions("DNA is found in which part of the cell ?", "LCSSNUKBUXBIVUBSDE", "Nucleus", "","NFUSELU","GQCAXVK","QXKAGVF"));

        allQuestions.add(new Questions("Xe is the symbol for which element in periodic table ?", "OCKNEKHEGNXFANPZGS", "Xenon", "","GXVNCG","NQPENO","CPVQGGN"));

        allQuestions.add(new Questions("Rh is the symbol for which element in periodic table ?", "KTVYRRDOUMJEOIHTXF", "Rhodium", "","VYWZOOQ","IXMHUDR","OZQYVXW"));

        allQuestions.add(new Questions("What is the most abundant element in the universe ?", "KGRDBSOCOTHEYYDNOO", "Hydrogen", "","GSVEVHD","YNGONRT","VTVGNS"));

        allQuestions.add(new Questions("The atomic mass tells the number of Protons and _______ in an atom.", "SLMNFERHOQOGUTHOEN", "neutrons", "","SHHTNUE","HUHYORN","YHHHHU"));

        allQuestions.add(new Questions("Ge is the symbol for which element in periodic table ?", "FWGENRMIAVZMWYJMAU", "Germanium", "","RMPTUEIT","APFUMGMN","TPMPTUF"));

        allQuestions.add(new Questions("______ energy is kind of energy a moving object possess.", "VEALDNCIOXIUTNUKNK", "Kinetic", "","ABIGNVK","DCLTEII","DIVBGAL"));

        allQuestions.add(new Questions("What is a very hard, transparent form of carbon, whose crystals are octahedral in shape ?", "NSMFDQTXNASTYFDIOO", "Diamond", "","DSTDWXS","AOYINDM","SXTWDSY"));

        allQuestions.add(new Questions("Which element has atomic number 3 in periodic table ?", "XRUGMJTHMCIZLOIBIM", "Lithium", "","MIHIHXF","GCLILTU","HILCXFG"));

        allQuestions.add(new Questions("Elements on the periodic table are ordered according to their _____ number .", "ICATYUIOIMABXJKJKJ", "Atomic", "","FALCIKR","MOZQBOT","FKORBZQL"));

        allQuestions.add(new Questions("Ca is the symbol for which element in periodic table ?", "MBOENZUCLPXOIQXCAC", "Calcium", "","CBEUJAO","MLIHCCM","EJHOMBC"));


        allQuestions.add(new Questions("Pure water freezes at  ____ degrees Fahrenheit temperature", "RNIBIWOYTOTZHYRTWT", "THIRTYTWO", "","FPTQYBTW","ROTHIMYG","PYMQGFB"));

        allQuestions.add(new Questions("Accumulation of which chemical leads to kidney stones ?", "CIEMLACUMBAOLABXTT", "Calcium", "Oxalate","CCTUCAXLE","TOIAHJLMA","JCTH"));

        allQuestions.add(new Questions("What is the longest bone in the human body ?", "GQNYUDDGMHFRCENUHQ", "femur", "","MZPRUM","EZSBTF","ZZMSBPT"));

        allQuestions.add(new Questions("What is the molecular shape of SCl6 ?", "OTAAZELDWWREDCDTHS", "Octahedral", "","UACDHHEO","RLKATLDF","FUHLKD"));

        allQuestions.add(new Questions("What is the study of water called ?", "OGPHOQRYLSZYYDNNYO", "Hydrology", "","GRQOPLHN","YYPEVOCD","EVQCPNP"));

        allQuestions.add(new Questions("Which heavy metal causes Itai Itai disease ?", "HDCUMMJCAGDIUBIOOO", "Cadmium", "","IMKJGLX","RDAUQMC","JLKRQGX"));

        allQuestions.add(new Questions("Which branch of science deals with the study of tissue found in the body of organism ?", "OPLOODHYTINMQIGEKS", "Histology", "","YYRHOYST","IWOLGORS","SRYORWY"));

        allQuestions.add(new Questions("In Periodic table elements are arranged according to their ______ number.", "CAARLCBMNTIIROLOCS", "Atomic", "","ALKCMIX","COWTAYO","XKYLWACO"));

        allQuestions.add(new Questions("Which science is sometimes called ‘central science’ ?", "RIQDUTIQSYMHDSEACW", "Chemistry", "","EHRUOYCI","QZSHMGTT","OUHTZQG"));

        allQuestions.add(new Questions("What are the brighter areas on the sun's surface called ?", "YAEYPTHHCFIDLWEUAW", "Faculae", "","MEFEPXO","UPACADL","XDPOEMP"));

        allQuestions.add(new Questions("What is the only human organ that can regenerate itself ?", "NFVPSJZBRKEITMEHLW", "LIVER", "","RULFEM","VHPTIM","FHPMMTU"));

        allQuestions.add(new Questions("What does the \"E\" in E=mc^2 stand for ?", "GEYFRJRDSFNPELOPZY", "energy", "","JYLCGAB","LNEYREP","PCLJBLYA"));

        allQuestions.add(new Questions("What is the only human organ that can float in water ?", "NULNUBTVYDESCVBSGV", "LUNGS", "","SGUNLL","MYXTND","TMLYDXN"));

        allQuestions.add(new Questions("What is the molecular shape of C2H2 ?", "CZZTGRANEIRAHLRRMD", "Linear", "","AXENWNH","XLYXIYR","WXYYNXHX"));

        allQuestions.add(new Questions("What is the name of that process in which oxygen is removed ?", "ERCIDONTKHEWJROXUN", "Reduction", "","ULMOTDRJ","CNEEITRL","LJRETLM"));

        allQuestions.add(new Questions("What is the formula of Sulfuric acid ?", "U2QH1HMZ4UO3KP5SSD", "H2SO4", "","5LS8VX","2HZOS4","L8VXSZ5"));

        allQuestions.add(new Questions("Which is the largest blood vessel in the body ?", "KTKOFADYXWXNRATVUH", "Aorta", "","BAJODR","RABUVT","UBJVRDB"));

        allQuestions.add(new Questions("Nicotine is an alkaloid found in the nightshade family of plants (Solanaceae), predominantly in ________.", "BSGOCBTCYMMCSAKDMO", "tobacco", "","XSBCNCA","OAOPBTF","FPNBSAX"));

        allQuestions.add(new Questions("______ is the scientific analysis and study of interactions among organisms and their environment.", "AIYYKZZZZEXVCOLGNO", "Ecology", "","YOORCJG","LKHEZMD","JDZRKMH"));

        allQuestions.add(new Questions("What is the atomic number of magnesium ?", "122569781535846975", "12", "","122569781","535846975","2569781535846975"));


         //arts and gk easy
        allQuestions.add(new Questions("Which artist created the sculpture \"The Thinker\" ?", "GTOLMNITDDIJUURAES", "Auguste", "Rodin","TRGUSCDAS","NOQDEUTIU","DUCSQT"));

        allQuestions.add(new Questions("What color do you get when you mix yellow and blue ?", "KEECBRDEUGNRLEAELB", "Green", "","RJENKS","HCNEGC","NSCJCKH"));

        allQuestions.add(new Questions("Brazil was once a colony of which European country ?", "RGZRUCALGTPDBPLOVB", "Portugal", "","TFZORLU","PAGWRZY","RWZZFY"));

        allQuestions.add(new Questions("What type of animal is known as the ship of the desert ?", "EJJTIMRALPUGESTFCQ", "Camel", "","CWMENH","TYCALA","WCNHATY"));

        allQuestions.add(new Questions("Porsche is a brand of car that originated in what country ?", "YIRJAQNJHOGRMEYGTU", "Germany", "","YGJANRE","VEMPAOD","DPJEOAV"));

        allQuestions.add(new Questions("Who was the first human to travel into space ?", "GARIZAUYRGIYDRRDNI", "Yuri", "Gagarin","CYIIRHURZ","JAGAXZNPG","ZZJPHXC"));

        allQuestions.add(new Questions("Which animal is the tallest in the world ?", "EWFSUVUJCRIGYUFASG", "Giraffe", "","OSREIFJ","NRNFALG","JLNROSN"));

        allQuestions.add(new Questions("The Roman numeral \"D\" stands for what number ?", "509512580536583170", "500", "","50951","83170","9518317"));

        allQuestions.add(new Questions("The slogan \"Just Do It\" was created in 1988 for which company ?", "LPKEHLTBIWNXSZLBTA", "Nike", "","XIIOKX","ONNKWE","NWOIOXXK"));

        allQuestions.add(new Questions("In which country is the Nobel Peace Prize awarded ?", "JORKMRKWNADGOMIRYG", "Norway", "","WQXYYAR","GRRENOU","YRUQEGXR"));

        allQuestions.add(new Questions("The Communist Manifesto was written by Karl Marx & _______ the two German philosophers.", "LJENIHEGIEDFRCORSW", "Friedrich", "Engels","REFSUENDH","ICERGLSIE","SUE"));

        allQuestions.add(new Questions("The first atomic bomb ever used in war-time was dropped on what city of japan ?", "ASHRFGEPJCMOSAIDIH", "Hiroshima", "","CROVIHRL","AHKASITM","ATVRLKC"));

        allQuestions.add(new Questions("Who is the author of the novella \"The Metamorphosis\", first published in 1915 ?", "AFKCANKFAZSPVFLFRK", "Franz", "Kafka","FOABLRAN","ATKKGZJF","JLGTBO"));

        allQuestions.add(new Questions("A group of whales is called as a _____ .", "JXCWPVPZWDHOEMLNUD", "POD", "","PEOKW","EDNZO","KEEZNOW"));

        allQuestions.add(new Questions("On ______ island the Statue of Liberty stand on.", "FABPELAIGRYRXGDVTX", "Liberty", "","IYLQRBD","DTLZBLE","LZLDBQD"));

        allQuestions.add(new Questions("What is the first book of the bible ?", "EVIKKNPGTWSHBESSIG", "Genesis", "","VENGTDG","EISISVS","VSIGVDT"));

        allQuestions.add(new Questions("What is the name of Shinchan's(Anime/cartoon character) favourite action hero ?", "EPTPVONANCEMJIKGKA", "Action", "Kamen","NPTAMIGZU","HOAKMDECN","HMZDPGU"));

        allQuestions.add(new Questions("Dewey, Huey and Louie were the nephews of which famous Disney character ?", "DDHHXNUACOOKDDLZON", "Donald", "Duck","WDOCQKNL","ARLMUFDD","RLMFWQ"));

        allQuestions.add(new Questions("J. R. R. _______ is the author of The Hobbit and the Lord of the Rings trilogy.", "LVKHXFIWEOKEDINXNT", "Tolkien", "","ELZTQFK","ONGICEV","VGQCZFE"));

        allQuestions.add(new Questions("Who is the author of the book \"A Brief History of Time\" ?", "IWPHAEWTGSKQENELNH", "Stephen", "Hawking","SATKHLHNV","ANEGPYEIW","YLVA"));


        allQuestions.add(new Questions("Diana Prince is the public persona of which fictional superhero ?", "WEWMRONDWERGBAONYM", "Wonder", "Woman","RNOAVEMOC","YNWWWDKEG","GWECVKY"));

        allQuestions.add(new Questions("What is the name of Shinchan's dog ?", "XAQHFNMKKKQLDSIOFR", "SHIRO", "","TIHOXS","MXNSSR","TMSXNXS"));

        allQuestions.add(new Questions("Who painted \"The Scream\" ?", "SVMRBHGNDOBRRUCEAD", "Edvard", "Munch","WALDNUHEW","VRZMDLCCJ","WZLJWCL"));

        allQuestions.add(new Questions("Manga are a type of comics from what country ?", "NAWDGOCDASLICGJFXP", "JAPAN", "","AJRLPF","SDNDRA","RSRDDFL"));

        allQuestions.add(new Questions("Who is doraemon's(cartoon/Manga character) best friend ?", "CNFXTPOTHCABIMKBJB", "Nobita", "","PITQNGQ","VMOIAFB","FGQVIQPM"));

        allQuestions.add(new Questions("Who won the Nobel Prize for Literature in 2016 ?", "NJDDRTABOZEBLWCYWT", "Bob", "Dylan","DLFOBBA","GSCGNIY","FGCISG"));

        allQuestions.add(new Questions("What musical instrument did Sherlock Holmes play ?", "XICJJPVDNAOAIFAQNL", "Violin", "","NIGNQSO","LNSAFIV","GSNSNQAF"));

        allQuestions.add(new Questions("In what year was the US Constitution written ?", "328175395125874178", "1787", "","328175","874178","32817584"));

        allQuestions.add(new Questions("What luxury British automobile brand was purchased by by Tata motors in 2008 ?", "ROUUAQUJXHGAEGINNR", "Jaguar", "","JDKBAPJ","AGQBMRU","JDPMBQBK"));

        allQuestions.add(new Questions("What does the Statue of Liberty hold in her right hand ?", "MHBQIBREATGOWBRZCU", "torch", "","ROTCDU","WHKHCR","KCDRUWH"));

        allQuestions.add(new Questions("The use of chopsticks originated in what country ?", "YDIACNLDHYYRJAAMFL", "China", "","CRCDNH","ANBQIZ","ZRQBDNC"));

        allQuestions.add(new Questions("In what year is Columbus credited with discovering the new world ?", "141753951258741792", "1492", "","141753","741792","17537417"));

        allQuestions.add(new Questions("Who wrote ‘The Magic Mountain’ ?", "HOSASNNAXDQMMTCYKS", "Thomas", "Mann","NMSACHAN","DMHTMOAN","CDNHMA"));

        allQuestions.add(new Questions("Which movie debut the first of Disney’s classic princesses ?", "KSEWXLGOWTLWJNIHCG", "Snow", "White","OENWCSHT","IWJDNHWO","CNWJDHO"));

        allQuestions.add(new Questions("Who wrote the book ‘Charlie and the Chocolate Factory’ ?", "GDYALRORSGLPWADHRR", "Roald", "Dahl","DGLRRAEB","YLDAIOHD","DYGIEBR"));

        allQuestions.add(new Questions("Who painted the picture “The Old Guitarist” ?", "CQUBLPAPIASSEPOQOV", "Pablo", "Picasso","PSLPAIBOA","AGOVSCSHI","GSIAVH"));

        allQuestions.add(new Questions("In which European country is Shakespeare’s Romeo and Juliet set ?", "UZWYNTVLRMUKKIEASX", "Italy", "","NIJALZ","TWKIAY","KJAIWNZ"));

        allQuestions.add(new Questions("Who wrote Candide ?", "IMVRTRCVMOLDAQKENG", "Voltaire", "","AVOLXER","VIXROTS","XVORSX"));

        allQuestions.add(new Questions("7x(2a+3b)=147, What does a & b stand for ?", "641753951258741793", "6", "3","641753951","258741793","4175395125874179"));

        allQuestions.add(new Questions("Who wrote Snow White ?", "TRELRTRWHMISOBEGTM", "Grimm", "Brothers","DJSLROU","BTOEHRM","MJODLU"));


        //arts and gk medium
        allQuestions.add(new Questions("Who wrote \"Alice's Adventures in Wonderland\" ?", "CRWXELJMKNLOCARISE", "LEWIS", "CARROL","MSCCIURLT","BZRLEAOVW","ZBUCMVT"));

        allQuestions.add(new Questions("What American artist is known for paintings of flags ?", "PQZEPAONZJHGMRSFSJ", "Jasper", "Johns","UYCSJHRNO","RPGJHOSAE","RYUHGCO"));

        allQuestions.add(new Questions("In which city was famous poet Dante born ?", "GIDCUWNPEOOFLERCPJ", "Florence", "","NFBMLYV","ECRRTEO","BTMRYV"));

        allQuestions.add(new Questions("Who was the court sculptor of Alexander the Great ?", "SXPCOURYFGILPZLYSU", "Lysippus", "","UIUINWS","SPDPYJL","JUIWND"));

        allQuestions.add(new Questions("What artist sold a balloon dog for $58.4 million ?", "EFKNSJIOSBOETITFTO", "Jeff", "Koons","NSOKRTCO","EEWFSJFF","TECRFSW"));

        allQuestions.add(new Questions("Who is the author of \"The Da Vinci Code\" ?", "RTBQQWNAAVXOOWNDVG", "DAN", "BROWN","DBONIHE","ARQWNRO","OIRHQE"));

        allQuestions.add(new Questions("What is the white part of the inside of an egg called ?", "NIUMLNWSADFCCZOEBE", "Albumen", "","LUCBBPM","YALNMEU","CLPMYBU"));

        allQuestions.add(new Questions("A teetotaler is a person that never drinks what?", "OGILQHXAILJCOUYDPU", "Alcohol", "","VHOOHAO","HLYSYCL","VYHOYHS"));

        allQuestions.add(new Questions("Who painted American Gothic ?", "XNWDGUZAJMMNETOORB", "Grant", "Wood","TTPNRTIO","QAGWDLOF","QTLIFPT"));

        allQuestions.add(new Questions("What is Van Gogh’s first name ?", "DNGIBEBCCTVEJCUNFA", "Vincent", "","CVINJEK","FPTXEEN","KEJEFXP"));

        allQuestions.add(new Questions("What is the musical term for “loud” ?", "LUFKNIEMORTSQEZEIO", "forte", "","ROTYEB","QPZFOC","QPCZBYO"));

        allQuestions.add(new Questions("Peter Parker is the alter ego of which superhero ?", "ISRIDMVKANVYLYSEYP", "Spiderman", "","ANMFIMSV","DZEYRSPZ","MZSFVZY"));

        allQuestions.add(new Questions("The author \"Hans _____ ______\"(full name) wrote the fairy tale \"The Ugly Duckling\" .", "IEHNRSITAREACNNDMS", "Christian", "Andersen","NDNISRELH","TSANAERCI","L"));

        allQuestions.add(new Questions("Joseph Smith was the founder of what religion ?", "MMOITKAOTTIBISNDMR", "Mormonism", "","OMRNSFIG","JRMVMIOG","GFIGVRJ"));

        allQuestions.add(new Questions("How many nights are there in \"Arabian Nights\" ?", "104175005101417901", "1001", "","104175","417901","41754179"));

        allQuestions.add(new Questions("What does Roger mean when communicating via radio ?", "SIKXJMMEMVEEUDECKR", "Received", "","KRPICLG","DEUEXVE","ULGKXP"));

        allQuestions.add(new Questions("According to Greek mythology, who was the goddess of beauty ?", "PETIXMDUORCHKNONQA", "Aphrodite", "","XSMEVPIH","RDCSTGAO","SXSVCGM"));

        allQuestions.add(new Questions("Which country and it's territories cover the most time zones ?", "RYEECIZRXWFNAFNFUV", "France", "","FACAEBN","LERNQTY","LEAQTYNB"));

        allQuestions.add(new Questions("In what year did Neil Armstrong and Buzz Aldrin land on the moon ?", "194175095101417969", "1969", "","194175","417969","94175417"));

        allQuestions.add(new Questions("The Roman numeral \"L\" stands for what number ?", "194175095101417950", "50", "","194175095","101417950","1941750951014179"));


        allQuestions.add(new Questions("The Lone Star State is the nickname for which U.S. State ?", "MWQBAASGTDEXEECVWS", "Texas", "","QSEAXT","PCAGTX","QGPCTAX"));

        allQuestions.add(new Questions("In what year did the Titanic sink ?", "191941750951014112", "1912", "","191941","014112","19410141"));

        allQuestions.add(new Questions("The United Kingdom's withdrawal from the European Union is commonly known as what ?", "KBIKRUSPPBERZTJXEY", "Brexit", "","BGEWRIJ","XNQTJOK","QGONKJJW"));

        allQuestions.add(new Questions("Which Patriot leader organized the Boston Tea Party in 1773 ?", "JAAUWASELPIMODMWAS", "Samuel", "Adams","SSLYKEAOM","ZMAUKLAAD","LOYKZKA"));

        allQuestions.add(new Questions("An animal that lives part of its life on land and part in water is known as what ?", "ILACTINAWOVMPHAFMB", "Amphibian", "","WAHLBSIP","AXMJNAIE","SLXJAWE"));

        allQuestions.add(new Questions("What is the name for the Greek goddess of victory ?", "JMLAENITXRVTNXCKBK", "Nike", "","TKEMNW","EBYIMG","MYGTMEBW"));

        allQuestions.add(new Questions("In the United States which breed of dog is commonly known as a firehouse dog ?", "HATDONIGHTALEAMHFM", "Dalmatian", "","DTALCAEP","GNKMJAMI","KECPJGM"));

        allQuestions.add(new Questions("Which animal has the longest tongue relative to its total size ?", "OACLHNHKMLLMVCEFEL", "Chameleon", "","ILONEEGA","PXKMHHOC","XHPOIGK"));

        allQuestions.add(new Questions("Who was the first NASA austronaut to visit space twice ?", "KOJMSUUGRGSSPIKKIX", "Gus", "Grissom","MGSKEFRG","OUNTEISS","FTNEEK"));

        allQuestions.add(new Questions("What popular soda beverage was originally developed as a mixer for whiskey ?", "WMTDEPANONLBIFUOVH", "Mountain", "Dew","SNKICMEAJ","JUNBOTWDD","CBJKJDS"));

        allQuestions.add(new Questions("Who wrote an ancient Chinese military treatise known as \"The Art of War\" ?", "UTUXLCZBVNZTZVSFKP", "Sun", "Tzu","YLZCOMN","QUSAKTU","LQYCMKOA"));

        allQuestions.add(new Questions("The Artful Dodger is a character from which novel ?", "SEWISTLDOVLRIIHGTX", "Oliver", "Twist","HSITMEIWF","TLIXOKRVJ","FMHKJXI"));

        allQuestions.add(new Questions("What was the Roman name for the goddess Hecate ?", "YJDIPKRVJHVOTIIAYK", "Trivia", "","TGAXVPI","QRIEMMT","MEMTXGQP"));

        allQuestions.add(new Questions("Which animal has the most legs ?", "ILDPXEWMMMELMIPVIU", "Millipede", "","EPLMNZDL","EIFIMILB","MLIBFZN"));

        allQuestions.add(new Questions("The letters of the popular fast food chain KFC stand for \"____ _____ chicken\".", "TLCKFYHENRKINUHFDE", "Kentucky", "Fried","BKUYCIEUF","ARIDKENST","ABIUS"));

        allQuestions.add(new Questions("Which land snake is the fastest snake in the world ?", "COECVDMLVBWAKAMBAH", "Black", "Mamba","VRBABMZA","KMLMKAMC","MRMZKV"));

        allQuestions.add(new Questions("Which artist created a stained glass window for the United Nations?", "LVHOMAGOACLUARUCVL", "Marc", "Chagall","AAPCHMGLC","CJALVRSLY","CYVJPSL"));

        allQuestions.add(new Questions("What is the fastest fish in the Ocean ?", "IFSQUXPSPRIYAQMLHU", "Sailfish", "","ZAFSLSI","LIAHCQC","QALCCZ"));

        allQuestions.add(new Questions("Which mammal has the longest gestation period ?", "RTTLBEUSNHEGSSPUQA", "Elephants", "","AFENXUTT","JESGPHLC","UJTXCGF"));

        allQuestions.add(new Questions("Snoopy from the comic peanuts is what breed of dog ?", "BNGBQSLEGLZDEUBAEG", "Beagle", "","XLLEAEM","EZIGANB","ZXNAIMEL"));


        //arts and gk hard
        allQuestions.add(new Questions("Who wrote the famous novel \"To Kill a Mockingbird\", published in 1960 ?", "EEAWRFHNRWEIXPAZLP", "Harper", "Lee","LPRIQJJV","RQSEHEEA","JQJVSQI"));

        allQuestions.add(new Questions("“Being and Time \" is an ontological treatise written by which German philosopher ?", "HMITXECIREEIGDGANR", "Martin", "Heidegger","RHOIDEIHG","REEATUMGN","UHO"));

        allQuestions.add(new Questions("Who invented the cotton gin in 1793, allowing for much greater cotton production ?", "ZIIVPYEETWHPBLTNFH", "Eli", "Whitney","EYIZJWNX","ISTEEZHL","XEJZSZ"));

        allQuestions.add(new Questions("Who wrote the novel “The notebook” ?", "YLAPNIAOHJRSKVCSRS", "Nicholas", "Sparks","RINMOCKOH","ZLSSNAAPS","OMZN"));

        allQuestions.add(new Questions("The author of harry potter series is J. K. _______.", "GNNFLHHWCRFCSXMOLI", "Rowling", "","XWONGLU","REIIWYN","NXWUEIY"));

        allQuestions.add(new Questions("Which President is on the United States 1,000 dollar bill ?", "VLCVNEREMJEADOGLHR", "Grover", "Cleveland","OECLEGTVS","VRNLADNRE","NTS"));

        allQuestions.add(new Questions("Who is the author of \"The Jungle Book\" ?", "NPDLUUQYKGIRRIADVA", "Rudyard", "Kipling","IIGKDKNPU","ULRUYRDOA","KUUO"));

        allQuestions.add(new Questions("The letters of the former communist country U.S.S.R. stand for \"Union of _______ _________ Republics\".", "LIHILSTOOATCVISSEE", "Soviet", "Socialist","TSOOSVLAI","RCSEIYTIM","MYR"));

        allQuestions.add(new Questions("In what year did the French revolution began ?", "119417509510141789", "1789", "","119417","141789","11941417"));

        allQuestions.add(new Questions("What is the sleepiest animal in the world, sleeping around 22 hours each day ?", "KZQYDMAUNWAODHNLWT", "Koala", "","OXTHLL","AABNKC","NLCBXHT"));

        allQuestions.add(new Questions("Polar bears feed mainly on what animal ?", "SZLSHYRNOWBECKMARZ", "Seals", "","FHCGAY","SMSGLE","HCMYFGG"));

        allQuestions.add(new Questions("Lemurs, a type of primate, are native to what island nation ?", "IDAASWMARCSDVGPFAE", "Madagascar", "","DPRSALUA","VAKCAMIG","UIVPLK"));

        allQuestions.add(new Questions("Which painter started the impressionist movement ?", "JUCAOLMTOELEUBNYYD", "Claude", "Monet","NLTMLJMCW","UGDEOAEDL","JWMDGLL"));

        allQuestions.add(new Questions("What is the national animal of Scotland ?", "JIUNTJICUFWFQROHNS", "Unicorn", "","UNKCNZR","OWINLRW","WKLWZNR"));

        allQuestions.add(new Questions("The art of paper folding is known as what ?", "AOXTIOMADQGKUFGRAI", "Origami", "","OTBAIJH","GRVMAIG","VJHTGAB"));

        allQuestions.add(new Questions("A group of lions is called as a _____ . ", "EIMYORKFJOZKJIBLDP", "pride", "","WPRILU","DAIEPX","UIXAWPL"));

        allQuestions.add(new Questions("Who painted the famous Dutch Golden age painting \"The Night Watch\" ?", "MAYURXENTUBERDESZQ", "Rembrandt", "","BYEDMRRQ","TAIYAZNM","YMIAQZY"));

        allQuestions.add(new Questions("Who was the Spanish surrealist painter best known for his work \"The Persistence of Memory\" ?", "RDOOQSÍLARLAADVMXA", "Salvador", "Dalí","FLODVRDBA","SÍAWLRAAZ","BZFAWR"));

        allQuestions.add(new Questions("The Spanish Civil War began in what year ?", "193119417509510146", "1936", "","193119","510146","11951014"));

        allQuestions.add(new Questions("How many hearts does an octopus have ?", "HEVEIESREQETNTHGTY", "Three", "","HENFDU","ATEERX","DNXFUAE"));


        allQuestions.add(new Questions("Who wrote “The tunnel” ?", "TABEAOSRETOSDTHNRE", "Ernesto", "Sabato","SERBTEATN","SROYABFTO","RTFBY"));

        allQuestions.add(new Questions("The writer Eric Blair went by what pen name ?", "LEDOBVAELLOZRRGGEW", "George", "Orwell","NJOEWOFGL","RLURDGENE","DNFUNJ"));

        allQuestions.add(new Questions("Who wrote the “Divine Comedy” ?", "VIHAAETDNNSGIRLIQE", "Dante", "Alighieri","NHSLAEIAW","EIBCDITGR","SWBC"));

        allQuestions.add(new Questions("Who painted Puberty ?", "LAGVLCEROEDNJDOHUM", "Edvard", "Munch","ARMMHFCOE","MNVVUDNOD","FVOMOMN"));

        allQuestions.add(new Questions("Who wrote the 1936 novel \"Gone with the Wind\" ?", "MGRMTITALECAHEIRLA", "Margaret", "Mitchell","IAEREGTRL","CKALHMMET","EK"));

        allQuestions.add(new Questions("In which Italian town was the artist Leonardo born ?", "YKHUIOMICXYNAUQLNV", "Vinci", "","NEVHEI","UHCFQI","HQUFEHE"));

        allQuestions.add(new Questions("The dingo is a free ranging dog found mainly in which country ?", "QFTSRTLLHUIAVEKYAA", "Australia", "","RARSAGAS","LTQLAUID","GLSQDAR"));

        allQuestions.add(new Questions("What is the term for a painting executed entirely in shades of grey ?", "TILAEAIXZGXFRZLSQT", "Grisaille", "","IPDSRLWJ","MAXGSLIE","SDJWPMX"));

        allQuestions.add(new Questions("Which art critic coined the term \"impressionism\" ?", "MROIOEJLLZYLSSEQUP", "Louis", "Leroy","ILORUCRO","SLUDEAGY","GCRAUD"));

        allQuestions.add(new Questions("Who Wrote Leviathan ?", "BHCUTSOOMYESHPBHAK", "Thomas", "Hobbes","TOAMAZHRO","BHSSMENBN","ANMNRZ"));

        allQuestions.add(new Questions("What digital currency is Satoshi Nakamoto credited with inventing ?", "TIZJXELQBINCOMOYXN", "Bitcoin", "","BBWNCOC","IQINEWT","BWCQNWE"));

        allQuestions.add(new Questions("Which Irish author wrote the avant-garde comic fiction,\"Finnegans Wake\" ?", "SEYJWDMACUUCWOWEVJ", "James", "Joyce","JMCJFJWA","OTESYELE","FEJTWL"));

        allQuestions.add(new Questions("Who painted \"Sunday Afternoon on the Island of La Grande Jatte\" (1884-86) ?", "ORSELERESIAUTXUGGN", "Georges", "Seurat","APGNESATR","OWGTSREEU","TNWPA"));

        allQuestions.add(new Questions("What form of energy is produced by an electric motor ?", "HMAYKHLGTZCECAIUNI", "Mechanical", "","NCXLMALT","UAOHIEQC","QOUXTL"));

        allQuestions.add(new Questions("Which art movement claimed to be anti-art ?", "AIEDDNHJYNLBSHQAGA", "Dada", "","ALADCA","DREQRA","ARLQCREA"));

        allQuestions.add(new Questions("In which city of spain is the famous Prado museum ?", "AXYJIYMRDBYZDHYMIG", "MADRID", "","EMPKZDC","IJRIPDA","PIZJCPKE"));

        allQuestions.add(new Questions("Who was the author of \"The Amityville Horror\" published in 1977 ?", "AOQDGBNNNNNOYMSJAJ", "Jay", "Anson","NIAYFNA","AYSUOPJ","YUPIAF"));

        allQuestions.add(new Questions("Which bird is often associated with delivering babies ?", "SOZOTQOMRYJSKBIFRA", "Stork", "","PRTKFT","TKTOYS","KYPTTFT"));

        allQuestions.add(new Questions("What was the name of Don Quixote’s horse ?", "XAHZOUICRNXTESKHFN", "Rocinante", "","EIRTWVNG","CONAWENT","TEWWVGN"));

        allQuestions.add(new Questions("Who wrote ‘The only way to get rid of temptation is to yield to it’ ?", "SLECRAIDRSVEWQCSMO", "Oscar", "Wilde","WOERDSCN","SAXXLIWJ","WJNSXX"));


        //entertainment easy
        allQuestions.add(new Questions("\"Sorry\" is a song recorded by Canadian singer Justin Bieber for which of his album ? ", "PULESFSUQRCQPOEVOJ", "Purpose", "","PRPPETW","RSUOUPS","TPWSUPR"));

        allQuestions.add(new Questions("Harley Quinn, Deadshot and Griggs are characters from which 2016 action movie?", "ASXSDLCNQUJIEDIDUH", "Suicide", "Squad","IQACBSDEV","UJSDSUVXI","VJVXBS"));

        allQuestions.add(new Questions("Which movie won Oscar in 2015 ?", "OMRBATYUPIXNDLCNND", "Birdman", "","ABIDZWY","NMRQBWL","YLWZQWB"));

        allQuestions.add(new Questions("What is the name of actor who  played the Character of  Peter Parker(Spider-Man ) in the Spider-Man trilogy ?", "TRUAILOEEIWBGMSOVY", "Tobey", "Maguire","AGTQOBHRI","PSAYMUTEE","THAQPS"));

        allQuestions.add(new Questions("\"Smack That\" is a song by which American singer/songwriter ?", "CCQIOMKKDNIQGCROAA", "Akon", "","KJOCAX","YATJON","JJYTOXAC"));

        allQuestions.add(new Questions("\"Waka Waka (This Time for Africa)\", called \"Waka Waka (Esto es África)\" in Spanish, is a song by which Colombian singer ?", "ESATDKZOBIAAREDZHD", "Shakira", "","KKSCIJO","RHAOBQA","BOKJCOQ"));

        allQuestions.add(new Questions("Which Avenger uses a hammer ?", "ATIHHGNGLOERRVEKVX", "Thor", "","RMDTWZ","OFHVAS","DAMWVZSF"));

        allQuestions.add(new Questions("In what famous Disney movie does the character Jafar appear ?", "FAKDPLLVDLHTNAAXIX", "Aladdin", "","BICLSPA","ADDNVMI","MVBCISP"));

        allQuestions.add(new Questions("What is the real name of the American supersoldier, Captain America ?", "TOTEGSRRNRAYXEXSVE", "Steve", "Rogers","VGQIREFVR","ISTSLROEE","LRVFIQI"));

        allQuestions.add(new Questions("ABBA was a pop group from what country ?", "SQDZUWKJXCWCAEEJUN", "Sweden", "","ZVLCYCS","NEWDCEO","COVCLYZC"));

        allQuestions.add(new Questions("Which pop star sang the national anthem at the 50th Super Bowl ?", "LHVUYBBADAGGVPMALX", "Lady", "Gaga","EYAUKAG","ALGDUAW","UEUKWA"));

        allQuestions.add(new Questions("What was the highest selling album of the 1980s in the United States ?\nHINT: album of Michael Jackson.", "DLEMEAILHRRTAGGAQK", "Thriller", "","IETZALE","LRRLROH","ZLAERO"));

        allQuestions.add(new Questions("Superman is a fictional superhero from what fictional planet ?", "VTAVRKPNYRRWTPEOOL", "Krypton", "","GFOPCNK","GTRGNYV","FGNVGGC"));

        allQuestions.add(new Questions("What was the name of the kleptomaniac monkey in the Disney movie \"Aladdin\" ?", "ABKDAZMUPTBILNAAPL", "Abu", "","ODARJ","UBIUG","IJDGOUR"));

        allQuestions.add(new Questions("Which character was played by Emma Watson in J. K. Rowling's Harry Potter series ?", "MHLMORIIENOEREEHNH", "Hermione", "","EZIWONE","LHROMJK","ZKLJOW"));

        allQuestions.add(new Questions("In the 2016 American fantasy adventure film, \"The Jungle Book\", what is the name of the orphaned human boy ?", "LMOMLWGLOPAJUGGIMX", "Mowgli", "","OLIWVHT","YLGVEMG","TVELYVGH"));

        allQuestions.add(new Questions("Who played the fictional anti hero Deadpool in the 2016 movie ?", "DOYRROAYNLNKEYSBIN", "Ryan", "Reynolds","SWAREDNYL","XEENRIOYO","OXWEIE"));

        allQuestions.add(new Questions("In what year was the original \"Jurassic Park\" film released ?", "191985349196325893", "1993", "","191985","325893","19853258"));

        allQuestions.add(new Questions("Who was the male lead in the 1996 summer blockbuster Independence Day ?", "LIISITHMFFLYTUMWOL", "Will", "Smith","LSLWMIPX","TWLMILHW","MWLLWPX"));

        allQuestions.add(new Questions("What pop singer is known as \"The Material Girl\" ?", "ONMGIQNNLHGQJZDVAA", "Madonna", "","DMANAZO","TTENOLB","OTBZTEL"));


        allQuestions.add(new Questions("For which film did Leonardo DiCaprio win his first Academy Award ?", "TEHAANVRVTEERNTTGI\n", "The", "Revenant","TAFUHERGV","GXNETNESK","SGXUFGK"));

        allQuestions.add(new Questions("“what do u mean” is a song by which Canadian singer-songwriter ?", "JLJRMNIOSUSEBGETIB", "Justin", "Bieber","TBIRBJBIU","BNSJLDEUE","LBUJBD"));

        allQuestions.add(new Questions("What are justin bieber super-fans called as ?", "BASIRGEEGXBLIKFEOZ", "Beliebers", "","RSCREIWE","ELRQBEBX","RXEQRWC"));

        allQuestions.add(new Questions("\"Not Afraid\" is a song by which American rapper from his album Recovery (2010) ?", "GPAMHDEMINRNLETOZE", "Eminem", "","EMMINRU","NMEMUEU","MMRUUNUE"));

        allQuestions.add(new Questions("Who’s hit single ‘Dangerous Woman’ has earned her a nomination for the ‘2017 Grammy Awards’ ?", "NRREEAINNACHAGAVDA", "Ariana", "Grande","GMNAJGE","RSSNDFR","JFSRMNSG"));

        allQuestions.add(new Questions("\"Cheap Thrills\" is a song recorded by which Australian recording artist ?", "SEACAMHSILYSRASIQC", "Sia", "","SIAAK","UXLAI","UALAKXI"));

        allQuestions.add(new Questions("“you belong with me” Song by Taylor Swift belongs to which  of her album ?", "LEFARZJFSMYTCEFXXS", "Fearless", "","NSEEYEO","FILSATR","NTEYOI"));

        allQuestions.add(new Questions("Which rapper is know as Mr. Worldwide ?", "FLAVWIZBTZWLPCCUBU", "Pitbull", "","POLPVJU","IHLOBTF","FPHOJVO"));

        allQuestions.add(new Questions("\"Famous\" is a song by which  American rapper ?", "KYMYMTNSEBWSXESNAJ", "Kanye", "West","YAXMTOEU","KHSAENCW","CMHXAOU"));

        allQuestions.add(new Questions("Which song of Major Lazer & DJ Snake won  Billboard Music Award for Top Dance/Electronic Song 2016 ?", "QOLUNGRPODSNAOEGSO", "Lean", "On","LEXOIXF","NGNATJL","XGJIFLTX"));

        allQuestions.add(new Questions("What school does Harry Potter attend ?", "VNCOATRCYUQGSLWSHJ", "Hogwarts", "","ONEEADS","GRAWTHB","NDBEAE"));

        allQuestions.add(new Questions("Which actor played the main character in the 1990 film \"Edward Scissorhands\" ?", "UYLJPPDMEONNUPXDHD", "Johnny", "Depp","OPYJNHJC","XKYPDMEN","KYMJXC"));

        allQuestions.add(new Questions("\"Love Me like You Do\" is a song recorded by which English singer  for the soundtrack to the film Fifty Shades of Grey (2015) ?", "UIWNIOELEOLGZDIGLL", "Ellie", "Goulding","GXLIMNEEI","VUIOGDELL","XVEIM"));

        allQuestions.add(new Questions("What is the name of the character played by “Leonardo DiCaprio”  in the flim The Wolf of Wall Street ?", "OFVEROBLTQRJJRDDAN", "Jordan", "Belfort","DEINUSROF","RLTEOJABB","IESBU"));

        allQuestions.add(new Questions("Who is lead actress in the flim lala land ?", "BAQXEOMTPXENMJSYTU", "Emma", "Stone","MSEONYMD","IETAAMXP","AIYDXMP"));

        allQuestions.add(new Questions("Which Australian actress played  Harley Quinn in the movie Suicide Squad (2016) ?", "EGOIPQOBSMRMXARTBA", "Margot", "Robbie","MOEGZIIDR","XIBRCOBTA","DCIXZI"));

        allQuestions.add(new Questions("\"Faded\" is a song by which Norwegian record producer and DJ ?", "UHAHKIANWAALLRNLER", "Alan", "Walker","AKELAWAL","GNXLRRPF","RXLPGF"));

        allQuestions.add(new Questions("Who plays Superman in the action film Batman v Superman: Dawn of Justice ?", "VNHSCFFNIKAYVERLLX", "Henry", "Cavill","NIZWTAPRS","YVADELLCH","WTDSZAP"));

        allQuestions.add(new Questions("\"Pillowtalk\" from the album Mind of Mine is the debut single by which British singer ?", "ZZMIYALALPNSNVNKAB", "Zayn", "Malik","AWYICALZ","MUNRKYIP","IYUCPWR"));

        allQuestions.add(new Questions("What is the meaning of the “wonderful” phrase, “Hakuna Matata” in english ?", "FHROPINWUERLSVOVBU", "No", "worries","SJRNHIEV","NKRRNWOO","VKNHJRN"));


        allQuestions.add(new Questions("Who was the female lead in the movie \"Titanic\" ?", "MLAIEVEZCTSTKLNYAW", "Kate", "Winslet","GBWTTENYB","MBAOILEKS","MGYOBBB"));

        allQuestions.add(new Questions("Whose 2013 world tour was called ‘The Mrs Carter Show’?", "OXCCGMAYUECOBBQUNE", "Beyonce", "","NYLENCL","CEYXOMB","LNYLMXC"));

        allQuestions.add(new Questions("What is the real name of the actor who played batman in the \"Batman v Superman: Dawn of Justice\" ?", "KECCPLPFIQEUNBEFIA", "Ben", "Affleck","AOCKENZF","WELMFRGB","MOZRWG"));

        allQuestions.add(new Questions("Who is the Snow Queen in the Walt Disneys animated movie Frozen ?", "GASILUCJEKFSPXKMEK", "Elsa", "","EKWIAQ","SKGLHD","IHKGWQKD"));

        allQuestions.add(new Questions("What is the name of the main character in God of War ?", "NASNTISYUNIEOKLWTR", "Kratos", "","OAKWERT","FEMSEDU","MFWDUEEE"));

        allQuestions.add(new Questions("Which Canadian rapper had Billboard hits with the songs \"Hotline Bling\" and \"Summer Sixteen\" in 2016 ?", "KXKADQNHEHRXLALVXT", "Drake", "","WBRAXF","ILEDKC","FXIWCLB"));

        allQuestions.add(new Questions("In Harry Potter movies who played the character of Ron Weasley ?", "IUGTCRLNZRPGWREUTL", "Rupert", "Grint","TGHGTURTE","TNRRPIRRF","THRFRGT"));

        allQuestions.add(new Questions("\"Sugar\" is a song recorded by which band for their fifth studio album, V (2014) ?", "M1O5NNAO4IMS5EGGRO", "Maroon5", "","56MIYAR","OCNNO5C","YNCIC65"));

        allQuestions.add(new Questions("Escape is the fifth studio album and second English album by which Spanish singer ?", "TEETNGLIVEIQSIURAS", "Enrique", "Iglesias","LUSSFEIYE","GNRQEIIZA","FZY"));

        allQuestions.add(new Questions("\"One Dance\" is a song by Canadian rapper Drake for which of his album ?", "WEIMPEEVVISZJGWUHL", "Views", "","SIJWXI","TJVDWE","IJWXTDJ"));

        allQuestions.add(new Questions("\"Steal My Girl\" is a song by which band ?", "XNTOITEEIIYNRDOOCE", "One", "Direction","NOJODINTC","ECZRMSEUI","JSCUMZ"));

        allQuestions.add(new Questions("Which movie won Oscar in 2016 ?", "THGJFDIEHTOESPVFGL", "Spotlight", "","LHESYNYT","IFTOJDGP","NFDYJEY"));

        allQuestions.add(new Questions("who played the role of Mark Watney in the movie The Martian ?", "QUAKXNNTPTOMUAMTDP", "Matt", "Damon","QHADMTNR","AMUXOTSA","SUHARQX"));

        allQuestions.add(new Questions("Which actor played lead role as Baahubali in the indian tollywood flim “bahubali 2 the conclusion” ?", "XIHTFRYSEAOOVAPASB", "Prabhas", "","PPCBBSR","SAAWHNS","NPCSSWB"));

        allQuestions.add(new Questions("Which movie won Oscar in 2013 ?", "FHRIOYSOUIVANYGFKG", "Argo", "","RYQRSA","IGSOPZ","IQYSSRPZ"));

        allQuestions.add(new Questions("Which actor has played the  joker in movie  “Suicide Squad “(2016) ?", "MLTRAEORDODZGQAEJA", "Jared", "Leto","VOTNELER","MYCDDAKJ","YNCVKDM"));

        allQuestions.add(new Questions("What is the name of Peter Parker’s best friend in the Spider-Man trilogy ?", "ZOHHYSNABNRRSORMJE", "Harry", "Osborn","RAZNSOXOY","ZHARZBGRW","ZGWXZZA"));

        allQuestions.add(new Questions("What 2013 film is about the mid-orbit destruction of a space shuttle and the attempts to return home ?", "SSYVOFGDGGURQIADTV", "Gravity", "","AVRXVPG","HKJBYTI","HVXBKJP"));

        allQuestions.add(new Questions("Who is the star of  flim \"Oblivion\" ?", "UTODTCRNSMZISUECRB", "Tom", "Cruise","CGAEOUKM","PSKTRITK","KTAKPGK"));

        allQuestions.add(new Questions("\"Numb\" is a song by American rock band Linkin Park from which album ?", "JMTEQOIZAREIYFWCRS", "Meteora", "","KAMTEJS","ERROOEE","OESJERK"));


        allQuestions.add(new Questions("Who played the role of Black Widow (Natasha Romanova) in the movie \"Captain America: Civil War\" ?", "SSJRETLOTSAACNHMON", "Scarlett", "Johansson","TATNNHLSC","AOGEORSJS","G"));

        allQuestions.add(new Questions("'Why are they here?' is the tagline to which mysterious science fiction film starring Amy Adams ?", "LIIUYRGZAJZLRAJVHE", "Arrival", "","LVZJIRW","VRZAVAZ","ZVJZZVW"));

        allQuestions.add(new Questions("Name the film about a WWII American Army Medic who becomes the first man in American history to receive the Medal of Honor without firing a shot.", "RDJKCGASMACAERNWIH", "Hacksaw", " Ridge","ITKAESBWR","DVCARKHGS","RTSVKB"));

        allQuestions.add(new Questions("Starring Leonardo DiCaprio, the film tells the story of a frontiersman's fight for survival on a fur trading expadition. Name the film.", "VTHEETBMANPVNNEERT", "The", "Revenant","NKHNHERZA","ETVWETKSK","ZKHSWKK"));

        allQuestions.add(new Questions("Directed by Michel Hazanavicius and starring Jean Dujardin, which film won the 2012 Academy Award for Best Picture ?", "STEIJSHARTWTCALODR", "The", "Artist","PRHTMSIL","TABLETUI","BUPILML"));

        allQuestions.add(new Questions("Which director is know for directing flims like Slumdog Millionaire, 127 Hours, and Steve Jobs ?", "RHELBRDYSNYOTZANLB", "Danny", "Boyle","QAMDETYN","LEABNIOY","QEITAM"));

        allQuestions.add(new Questions("Who does the voice over for Dory from \"Finding Nemo\" and \"Finding Dory\" ?", "DFEBELENLLEREEGGSN", "Ellen", "Degeneres","EWERNNIDE","EEEHGELLS","WIHE"));

        allQuestions.add(new Questions("What is Jay-z’s real name ?", "URHGAATENVSWCHTHRY", "Shaun", "Carter","RAUZSDADR","EMNATHQRC","DRZADQM"));

        allQuestions.add(new Questions("\"Roar\" is a song by which American singer for her fourth studio album, Prism (2013) ?", "FBRAYPZETTRGYDLKCN", "Katy", "Perry","YKPATYRO","XNXERYUS","NYXSUXO"));

        allQuestions.add(new Questions("\"Umbrella\" is a song by which singer  from her third studio album Good Girl Gone Bad (2007) &  It features American rapper Jay Z ?", "AJKENIJINRGNHAVRLS", "Rihanna", "","OANHNRE","RNKYIAA","KYERONA"));

        allQuestions.add(new Questions("Which artist had hits with the songs \"When We Were Young\" and \"Hello\" in 2016 ?", "PIOYFEEXDTNLALNLWL", "Adele", "","ELEIAD","PDEELA","IEAPLED"));

        allQuestions.add(new Questions("Canadian singer and songwriter Abel Makkonen Tesfaye is better known as ?", "HFDEHKWNETNHPLHWEI", "The", "Weeknd","EBWKHERY","TSQNMDEE","SBQEYMR"));

        allQuestions.add(new Questions("Whats the name of the Sleeping Beauty ?", "RRPAWOUEBBJIYCPOYA", "Aurora", "","ROUMHTO","AZACRIO","OCHMZITO"));

        allQuestions.add(new Questions("In the Pixar computer-animated 2016 film \"Finding Dory\", Dory is what kind of animal ?", "DFKSHHPIWEIWTPISSF", "Fish", "","SVYINF","SIUDWH","DYNIUSVW"));

        allQuestions.add(new Questions("\"It Ain't Me\" is a song by Norwegian DJ Kygo and American singer ________. It was released by Sony and Ultra on 17 February 2017.", "GESGYABFOMZJENVLEO", "Selena", "Gomez","SJOGEAKPS","ZEMVGELND","VGKPJSD"));

        allQuestions.add(new Questions("\"Mockingbird\" is a song by American rapper Eminem form which of his album ?", "MNGUHDRIEOELZYCIXE", "Encore", "","ONEMREI","ECJLRHF","RLMFIHEJ"));

        allQuestions.add(new Questions("which  fashion model  received the TRL Awards for ‘Best Look’ in 2016 and in the same year she  received the British Fashion Award for ‘International Model of the Year’ ?", "RIWINDUDDIHGAGIZKF", "Gigi", "Hadid","UCIDHIXC","GGGLDIIA","LXUCGIC"));

        allQuestions.add(new Questions("What was the name of the whale in the 1993 movie, \"Free Willy\" ?", "KZUMKJEMJVOPIKPZXZ", "Keiko", "","RKOEOO","KIQWXK","XOORWQK"));

        allQuestions.add(new Questions("Who Played the lead in 'The Last Boy Scout'(1991) ?", "YEIICRELBLWWSTAUNZ", "Bruce", "Willis","QIZLEIBYB","UWRSWLCPV","VYWPQBZ"));

        allQuestions.add(new Questions("Who had played the role of The Hulk in the movie Avengers: Age of Ultron ?", "DZVALIKFRVWRAMLOUF", "Mark", "Ruffalo","TDRKARAMU","FVFCLLDKO","KDLVCTD"));


        //entertainment medium
        allQuestions.add(new Questions("\"See You Again\" ft Charlie Puth is a song recorded by which rapper ? \n The track was commissioned for the soundtrack of the 2015 action film Furious 7.", "FZWLTAIFLKAIUHHWIZ", "Wiz", "Khalifa","GIAZIDKK","WCFHJNAL","KJGNCD"));

        allQuestions.add(new Questions("What fictional city is the home of Batman ?", "AQBAXVPDMOBTQHOTGN", "Gotham", "","ZKASHXO","JMGTHGN","JXKZNGSH"));

        allQuestions.add(new Questions("\"Billie Jean\" is a song by which American singer ?", "EWJELCOLINHSHKMACA", "Michael", "Jackson","KQIASOAAM","JLCECGHSN","SAQG"));

        allQuestions.add(new Questions("Who was the director of the multi award winning film La La Land ?", "EZEEAIHICDJLLHMENA", "Damien", "Chazelle","NZIAKLHCW","MEXXALEDE","XKWX"));

        allQuestions.add(new Questions("\"Radioactive\" is a song by which American rock band ?", "BIAPGGOSDMNAGRNYIE", "Imagine", "Dragons","SEDNLIAVI","XNGRMOGAS","XVLS"));

        allQuestions.add(new Questions("\"Me, Myself & I\" is a song by  American rapper G-Eazy and American singer ________.", "RADKREBRXERCEZHBBR", "Bebe", "Rexha","EXJHKSEE","HBRBOVLA","OKSLJVH"));

        allQuestions.add(new Questions("\"In the Name of Love\" is a song recorded by Dutch DJ and record producer ________ and American singer and songwriter Bebe Rexha.", "IRINRWGAAMRAMTXMXG", "Martin", "Garrix","IEODRBGMR","CXTRJIAAN","DBOJCE"));

        allQuestions.add(new Questions("\"Shape of You\" from the  album ÷ (2017) is a song by which English singer-songwriter ?", "HVEGODYEZIEHNARSSE", "Ed", "Sheeran","EULDRHSB","TWAEDEMN","LDTWBMU"));

        allQuestions.add(new Questions("What is the name of the hero in \"The Lion King\" ?", "OPXMRASXZBUIBIKRGO", "SIMBA", "","EHIAMS","BJEOLJ","HELJJEO"));

        allQuestions.add(new Questions("Wake Me Up is a song by which Swedish DJ and electronic music producer ?", "MQVYNILTIFGICPMAIU", "Avicii", "","CTIETAZ","IIHXTTV","HEXTTTTZ"));

        allQuestions.add(new Questions("\"Cry Me a River\" is a song recorded by which  American singer-songwriter  ?", "RISEKUMEABRTNJLTTI", "Justin", "Timberlake","RRMIEATNB","TEUGJLSKI","RG"));

        allQuestions.add(new Questions("\"_____\" (English: \"Crazy\") is a song by Colombian singer-songwriter Shakira, taken from her seventh studio album, Sale el Sol (2010) ?", "KSLADYRGLNCMOFYSIO", "Loca", "","MYLNTO","TLCASF","SNYMFLTT"));

        allQuestions.add(new Questions("Which is the main character in 'Dragon Ball Z'(Japanese animated series) ?", "KOULTKKUULJGOGOSGV", "GOKU", "","DTZBBG","VKUOGR","GRVTZBBD"));

        allQuestions.add(new Questions("\"Side to Side\" is a song recorded by American singer Ariana Grande for which of her album ?", "OTZWANMGEDLRUHNOSA", "Dangerous", "Woman","AFNEGFJRD","NWUMONSAO","NFJF"));

        allQuestions.add(new Questions("\"Where Are Ü Now\" is a song produced by American EDM artists ______ and Diplo under their collaborative effort Jack Ü, with vocals from Canadian singer Justin Bieber.", "KSXLQIDLRPVHPRERJP", "Skrillex", "","EALKLRW","VXEICUS","UWVCAE"));

        allQuestions.add(new Questions("______ is the debut studio album by American rock band Linkin Park, released on October 24, 2000 through Warner Bros. Records. The album was a huge commercial success.", "OHYMTRIRYVBJHDQIEL", "Hybrid", "Theory","HDDXGDROB","QTIRHOEYY","DDOQGX"));

        allQuestions.add(new Questions("“Peace Is the Mission” is the third studio album by which American electronic music band ?", "LPMOCELAURZFAMJERM", "Major", "Lazer","JAEJEVAA","ZRLMROMB","EBVJMA"));

        allQuestions.add(new Questions("Who plays Jon Snow in the series \"Game of Thrones\" ?", "ISAHSIRHOTGNDTKNGA", "Kit", "Harington","FGNMONITK","GSRHIABAT","GSFBMA"));

        allQuestions.add(new Questions("Who played the role of Catwomen in the movie \"The Dark Knight Rises\"(2012) ?", "AHJWANHAPGIYUETANU", "Anne", "Hathaway","AHWANATYW","LHGAMINDE","LMIDWG"));

        allQuestions.add(new Questions("What was the name of Chandler Bing's character in \"FRIENDS\" ?", "ERTJYHSTSPLEWGALMR", "Matthew", "Perry","HRJYOEPFY","AQETERTMW","YEQJFO"));


        allQuestions.add(new Questions("“They said I rap like a robot, so call me Rapbot” is lyrics from which song of Eminem ?", "DPXRAOTTGDPVABJXBQ", "RAP", "GOD","FLDPALO","RRDGOPY","DYRPFOLL"));

        allQuestions.add(new Questions("\"On the Floor\" is a song recorded by which  American singer  for her seventh studio album, Love (2011). Featuring American rapper Pitbull ?", "OPRNZJICNWVGEECFLE", "Jennifer", "Lopez","NREPVOJLE","FZNEIRBWN","RWVBN"));

        allQuestions.add(new Questions("selena gomez’s song “kill em with kindness” is from what album ?", "AIEVTRILSVMZNPZTFE", "Revival", "","EIBUVVL","ONKRHAT","KNBTUOH"));

        allQuestions.add(new Questions("What was the band known as Linkin Park originally called ?", "BAFAEBXVOIBZROIWON", "Xero", "","QREUNT","UFWOCX","NCFQUUTW"));

        allQuestions.add(new Questions("U2's \"Angel of Harlem\" was written about which singer ?", "BHWXIGEAYLOLLXIIKD", "Billie", "Holiday","IDBOMIHYO","AALEHBLIL","OABMH"));

        allQuestions.add(new Questions("The fans of Taylor Swift are known as what ?", "TRIUISFSTWDNVEITWE", "Swifties", "","EIITEMN","CSKKWFS","NMKCKE"));

        allQuestions.add(new Questions("Who gave the voice for Spongebob Squarepants ?", "TNJQMDYKWLNBOXWEPU", "Tom", "Kenny","XATNOLG","NYMDAKE","AXDGAL"));

        allQuestions.add(new Questions("\"California King Bed\" song  belongs to what album of rihanna ?", "BDWQFGUNQOWLZHIBCM", "Loud", "","OQLUDN","XGQCIQ","XQCQIQGN"));

        allQuestions.add(new Questions("What is Michael J. Fox's middle name ?", "XEXMQYDNFJZWQRQAXN", "Andrew", "","NSRUVWA","CXXIDED","XUCXSVID"));

        allQuestions.add(new Questions("In the Disney movie \"Beauty and the Beast\", what is the name of Gaston's bumbling sidekick ?", "RFNVLDOLEFMURFGNIB", "LeFou", "","MOFCME","LBIYUQ","BCQMMYI"));

        allQuestions.add(new Questions("Who directed the 1977 movie Star Wars ?", "EPYKLDASOCUGKPUERG", "George", "Lucas","OIPOESZAG","SECRKUGXL","PKOZXIS"));

        allQuestions.add(new Questions("In which American state was Madonna born ?", "IUNIICLCRHHMHGBNGA", "Michigan", "","IZGJWMN","BCSIHAA","SJBAWZ"));

        allQuestions.add(new Questions("In what country was the very first Hard Rock Cafe opened ?", "ULNQDRODANVHEFRDXO", "LONDON", "","DLTLHIW","SONKOEN","HSWKIETL"));

        allQuestions.add(new Questions("“1989” is the fifth studio album of which American singer-songwriter ?", "YWFRNMIQZTLSPFTAOC", "Taylor", "Swift","NWYTGNRFW","ASITIFOLJ","WNNGJIF"));

        allQuestions.add(new Questions("What song by Michael Jackson contains the lyrics \"Annie are you OK?\" ?" , "OOLHGGMTLIOCNIRASM", "Smooth", "Criminal","HRAHOSMDC","MITILNAIO","DHAI"));

        allQuestions.add(new Questions("\"Counting Stars\" is a song by American pop rock band OneRepublic from their third studio album, ________.", "AVJEFIITIZQGFZNFNG", "Native", "","NTIVBAO","IPUXGPE","GXPIPBOU"));

        allQuestions.add(new Questions("In what year was the first Harry Potter movie released ?", "020098070502304001", "2001", "","020098","304001","09830400"));

        allQuestions.add(new Questions("BB-8 is an astromech droid from what film franchise ?", "ACSSRAKRIOOTWVNSMF", "Star", "Wars","UWAJAYR","SSTRCEC","UYCCEJ"));

        allQuestions.add( new Questions("\"Yeah!\" is a song by which  American singer from his album Confessions ?", "EEWZYSNFXBRKPMHNRU", "Usher", "","MFERKH","SASQUB","KFAQMBS"));

        allQuestions.add(new Questions("What is the name of Mickey Mouse´s dog ?", "OVQBLJTXHDCZWPKUDZ", "Pluto", "","OMTLPZ","WUGSZK","SZWZMGK"));


        allQuestions.add(new Questions("Who is a famous rap singer and song writer of the United States who is best known for her songs ‘I Get Crazy’ and ‘Super Bass’ ?", "DTAKTNYYNIIJMUCIPG", "Nicki", "Minaj","TIANCMXJ","OKITISNJ","OSTJXT"));

        allQuestions.add(new Questions("Which singer-songwriter has the tattoo says “Anuugacchati Pravaha” which means “Go with the flow” in Sanskrit ?", " TRLKYPRMATNBZJNMYE", "Katy", "Perry","ESTYETME","YORAPREK","OMEESTE"));

        allQuestions.add(new Questions("Who has been nominated for the Grammy Awards 12 times and won the Award for Best R&B Album for his album ‘F.A.M.E’ in 2012 ?", "FVFRGCMHWRIBSXSOYN", "Chris", "Brown","BOXVRCRF","WYMSNIAH","YAFMXV"));

        allQuestions.add(new Questions("Who has played the Diana Prince (Wonder Woman) in the movie \"Batman v Superman: Dawn of Justice\".", "DFWOESGAGXOGLYPAIT", "Gal", "Gadot","SAGTYCN","GLODATG","GCNSYT"));

        allQuestions.add(new Questions("Which actress played the role of 'Bella Swan' in the movie \"Twilight\" ?", "TREWRNXSSTAIITPTEK", "Kristen", "Stewart","SAJETTRWP","RTEISGKVN","PVGJ"));

        allQuestions.add(new Questions("Which comedian is know for his work in television as a cast member on \"Saturday Night Live\" and as the host of late-night talk show \"The Tonight Show\" ?", "MNMFRQLIKJLAOEMYOC", "Jimmy", "Fallon","WLJLCFONI","MMAXGJYVO","XJGOVCW"));

        allQuestions.add(new Questions("Which actress has played Phoebe Buffay in \"Friends\"(American sitcom) ?", "SWOUDIPLKTJLARTXSW", "Lisa", "Kudrow","OMWZDQKU","ASTIIROL","QMOITZ"));

        allQuestions.add(new Questions("The Chainsmokers are an American DJ/producer duo consisting of Andrew Taggart and _______ .", "XLAAGPELLYHPDYBLEU", "Alex", "Pall","WLAAPLF","KXWIQEL","WWFKQI"));

        allQuestions.add(new Questions("\"Story of My Life\" is from which album of one direction ?", "HMNMSEYIDGIITEORMQ", "Midnight", "Memories","MMGICMNLD","EHESRTOII","CL"));

        allQuestions.add(new Questions("\"Toxic\" is a song recorded by American singer _______ for her fourth studio album In the Zone (2003).", "DNSBRICREYDPASETWA", "Britney", "Spears","BMREMEEYT","NSPSRAMUI","MUMME"));

        allQuestions.add(new Questions("\"Bailando\" (English: \"Dancing\") is a song by which singer ?", "UAGLSKISQEENIEEIRI", "Enrique", "Iglesias","LQASNISGR","EIIUIESET","TIS"));

        allQuestions.add(new Questions("‘I Will Never Let You Down’, became which singer’s fourth UK number one in 2014 ?", "YIZZVIJONTRRETVAAQ", "Rita", "Ora","ROUEAAI","NRQBNTH","NQENUHB"));

        allQuestions.add(new Questions("Which actor that once played James Bond previously competed in the Mr. Universe bodybuilding competition ?", "SNYKRNNMZFTOEENACM", "Sean", "Connery","OWSLRFNYW","CNAXUEEPN","WFLWUXP"));

        allQuestions.add(new Questions("What 2013 science fiction blockbuster starred Sandra Bullock and George Clooney ?", "JVGFTSYURSAQKIYPTT", "Gravity", "","CITYKGQ","ABZIRCV","BZIKQCC"));

        allQuestions.add(new Questions("Which famous singer appeared in the movie Mad Max: Beyond Thunderdome ?", "FURVITTENXEDZRSNAF", "Tina", "Turner","ANHRATTE","RRMSRIUN","HRASMR"));

        allQuestions.add(new Questions("Who is the lead singer for the American rock band Pearl Jam ?", "ETDVRDRDDSERIEOELI", "Eddie", "Vedder","DDDDHZRIT","VKEEFTERE","HTZFKTR"));

        allQuestions.add(new Questions("What was Madonna’s first UK top ten single ?", "OCQOHPHSDVAWYULIIZ", "Holiday", "","YIOHXRY","WEDPPAL","RYPPWXE"));

        allQuestions.add(new Questions("What is the name of the pug in Men in Black ?", "UZNYKYVORKJOQYTFFA", "Frank", "","GGRONI","YFAKZF","ZOYGIFG"));

        allQuestions.add(new Questions("Sherlock Holmes brother called as ______ holmes.", "HRLSRCOOHZFLRYCVTM", "Mycroft", "","WCPMRTS","XFOSGTY","WGXTSPS"));

        allQuestions.add(new Questions("Who directed the movie Black Swan ?", "OGROISREANAYENFRDK", "Darren", "Aronofsky","NOKONDSYR","AYAERRFRQ","RQY"));


        allQuestions.add(new Questions("Gangnam Style is the 18th K-pop single by the South Korean musician _____.", "YSYHBQXEKPFDISTUQC", "Psy", "","SYQBP","CPARK","RCQKABP"));

        allQuestions.add(new Questions("In \"Rush Hour 2\" who played lead actor role as character Chief Inspector Lee ?", "AORCAIEJAVOHLCCKNQ", "Jackie", "Chan","AAAMHJKB","PCIENMUC","UAMPBM"));

        allQuestions.add(new Questions("In \"Avatar\" movie what was name of fictional character played by Sam Worthington ?", "RLKAJELCSEKRZUSQUY", "Jake", "Sully","QFKUEGLI","WNAYSTLJ","QITWFNG"));

        allQuestions.add(new Questions("What is the name of leopard in kung fu panda ?", "LSASNRULUIZGJUNYMT", "Tai", "Lung","TNTYLNO","FEIGUAY","YTNYEFO"));

        allQuestions.add(new Questions("Which actor played lead role as professional thief in the movie “Inception” (2010) ?", "OORNOHIIADETLDPCRA", "Leonardo", "DiCaprio","IDLAOOPGD","CNEAERIOR","EG"));

        allQuestions.add(new Questions("Which actor played the role of Edward Cullen in the movie \"Twilight\".", "IEPTSRRAOUBVOTLNNT", "Robert", "Pattinson","OATWNPBBS","OYTNITRRE","BWY"));

        allQuestions.add(new Questions("Who played the lead role as fictional character Cade Yeager in the movie \"Transformers: Age of Extinction\" ?" , "GRYMKAWHRBWFSAMLYE", "Mark", "Wahlberg","RBLMGWEYM","AAPHDKMRB","MPMDYB"));

        allQuestions.add(new Questions("Who has played Queen in the movie \"Snow White and the Huntsman\"(2012) ?", "EVNRARZOTEELXIHCZH", "Charlize", "Theron","HNILNTAKO","ERRHRZEKC","NKKR"));

        allQuestions.add(new Questions("Which actor has played Yip Man in the movie \"Ip Man 3\"(2015) ?", "NWNDHFNAYOIOJEKKJE", "Donnie", "Yen","NNWEIYEO","JXNJNCCD","JNCWJXC"));

        allQuestions.add(new Questions("Which actress has played Lois Lane in the movie \"Man of Steel\"(2013) ?", "DFGFMSYASKAITATMVN", "Amy", "Adams","DAAFRMY","PMAAANS","PRAFAN"));

        allQuestions.add(new Questions("\"Let It Go\" is a song by which singer-songwriter ?", "ITOYCLOMHADSEOTDIV", "Demi", "Lovato","OITESMZO","ARDEVLLD","SEDLZR"));

        allQuestions.add(new Questions("\"Let Me Love You\" ft justin bieber is a song recorded by which French electronic music producer ?", "KPRRNSJYEUANOXDNCL", "DJ", "Snake","IKNEEAY","LDJIADS","ILEAIDY"));

        allQuestions.add(new Questions("Which Indian actress first appeared as Alex Parrish  in American drama series Quantico ?", "HNRLORVPKAANIACWPY", "Priyanka", "Chopra","IFRYRAWNP","AAHOCKPUM","UWMF"));

        allQuestions.add(new Questions("\"Despacito\"(Spanish version) is a song by Daddy Yankee and ______.", "IFIXLNRNUFDIPOESZS", "Luis", "Fonsi","TFVINIRD","LOQISUSR","RVDRQTI"));

        allQuestions.add(new Questions("In \"The Amazing Spider-Man\"(2012) which actor played Spider‑Man ?", "EAAOMDWNGDFLRIAFER", "Andrew", "Garfield","EAFLRREQD","DGANWIEGL","ELQG"));

        allQuestions.add(new Questions("In Ice Age: Continental Drift (2012) what kind of animal is Manfred ?", "GLWNEAYHWTNBEFEPIJ", "ELEPHANT", "","ELTNLQX","AEPQECH","XLQCQE"));

        allQuestions.add(new Questions("\"Love the Way You Lie\" is a song recorded by which American rapper featuring the Barbadian singer Rihanna ?", "IPYJREPMLYQPZEMBEN", "Eminem", "","JIJVDEU","YEMUNHM","HUYJDUVJ"));

        allQuestions.add(new Questions("In \"X-Men Origins: Wolverine\" who played Wolverine ?", "HAHQJUGWMJMCUKADNR", "Hugh", "Jackman","WFKGFJKMH","ADJCAUHHN","DFHJFWK"));

        allQuestions.add(new Questions("Which actress has played the role of Leigh Anne Tuohy in the movie “The Blind Side” ?", "WSUDYDLLOBLKRHANAC", "Sandra", "Bullock","NUKSDIASL","AWCLREOLB","SEWLI"));

        allQuestions.add(new Questions("\"Both\" is the third single from American rapper _______ .", "UAGDMLZINTBCICMUEL", "Gucci", "Mane","ELNBRINU","MAICGCEL","RBLNLEI"));


        //entertainment hard
        allQuestions.add(new Questions("What movie is about the first American cargo ship to be hijacked in 200 years ?", "LGATJITPILINSCPPAH", "Captain", "Phillips","PPITPHSPI","AOLCWILNA","OWP"));

        allQuestions.add(new Questions("Movie won Oscar in 2014 was  \"12 _____ a ______\".", "UAAUVSRLECMSEVBYHS", "years", "slave","XALEILVS","YAYSRKEC","LKCIXY"));

        allQuestions.add(new Questions("Guess Fantasy/Science fiction film: A robot who is responsible for cleaning a waste-covered Earth meets another robot and falls in love with her. Together, they set out on a journey that will alter the fate of mankind.", "WAHWLALEWEJLLEWMNJ", "WALL", "E","ALSAPN","EWRNPL","RSNPNPA"));

        allQuestions.add(new Questions("\"She Doesn't Mind\" is the second single from the Jamaican recording artist ________.", "LBNGULEADTPKETANWS", "Sean", "Paul","WUENEYA","MPSAELU","YEUEMW"));

        allQuestions.add(new Questions("The 'Lego Movie' was a box office hit around the world.\nWho voiced the lead character of Emmet Brickowoski ?", "RAVTJLLICNTHNRRSFP", "Chris", "Pratt","SRPYCHGQ","TRASICTY","YYCSQG"));

        allQuestions.add(new Questions("Which much anticipated film opened on December 2016 and stars Felicity Jones ?", "OZMNEEOHUGKERBFBGO", "Rogue", "One","OEVINEF","RUOUGEH","EFHIVU"));

        allQuestions.add(new Questions("\"Stitches\" is a song recorded by which Canadian singer ?", "PINEPEDNMSEHHDWSTA", "Shawn", "Mendes","EXNEDWRKH","ISEAVNSSM","XKIVRSE"));

        allQuestions.add(new Questions("\"Shake It Off\" is a song recorded by which American singer-songwriter ?", "TBYFSLWWTNRIYOIOAR", "Taylor", "Swift","IFNYWAVXL","LWTATRSOG","AGXNWLV"));

        allQuestions.add(new Questions("\"Party Rock Anthem\" is a hit song performed by the American recording duo ______.", "APOOLMLRFJQPGWNGKI", "LMFAO", "","OGASLZ","FNMOAH","GASHONZ"));

        allQuestions.add(new Questions("Complete the Lyrics: Hey I just met you, And this is crazy ,But here's my number, So call me ______... ", "MQMAWMPHEAVKAUWEBY", "maybe", "","YJEIUM","DWAYMB","DUMWJIY"));

        allQuestions.add(new Questions("Which actress received international recognition in 2015 after landing the lead role of Anastasia Steele in the romantic drama \"Fifty Shades of Grey\" ?", "TJYODANQHWOSNARKON", "Dakota", "Johnson","OTDKZJANS","ONOOHNKAV","NOKVZ"));

        allQuestions.add(new Questions("What is the name of Spider‑Man uncle in Spider-Man (2002) ?", "UFMVXBESHEFQBSRSNX", "BEN", "","WEBFH","SQSUN","SSWQUFH"));

        allQuestions.add(new Questions("Robbert van de Corput, performs under what stage name ?", "CDRWSLDEDHZLLLRAHO", "Hardwell", "","WRHAQLN","DKEAKLO","QNKAKO"));

        allQuestions.add(new Questions("Full form of PPAP is 'Pen ______ Apple ______'.", "XPENDSELALEPPNPEIV", "Pineapple", "Pen","AKPNCPEEW","PPLEIFNPE","ECFWKP"));

        allQuestions.add(new Questions("\"Tik Tok\" (stylized as \"TiK ToK\") is the debut single by which American recording artist ?", "KKKPQERZHKABVESLEK", "Kesha", "","JKEEBM","TESHAP","BEETJMP"));

        allQuestions.add(new Questions("\"The Lazy Song\" is a song recorded by which singer-songwriter ?", "NVSOYAMJFOFLORRVUB", "Bruno", "Mars","JJABNBPO","DURRXNSM","NJDPJBX"));

        allQuestions.add(new Questions("Which Indian actress has played the role of Serena Unger in the movie \"xXx: Return of Xander Cage\"(2017) ?", "DCZEPENKAPIEDAOAUK", "Deepika", "Padukone","QPKNUEKEO","PDPQIDEAA","PQQ"));

        allQuestions.add(new Questions("Complete the Lyrics: Now watch me whip (kill it!), Now watch me ____ ____ (okay!).", "HADFOEEFZNABCETNGA", "nae", "nae","BCWAMNE","ARELPNV","LWRPVCBM"));

        allQuestions.add(new Questions("What is the name of the character Leonardo DiCaprio plays in \"The Great Gatsby\" ?", "YVYKTZGWOZBSJAAAEJ", "Jay", "Gatsby","TAYGGMYN","YASJMLBN","MNNYGLM"));

        allQuestions.add(new Questions("The ______ are a British pop rock band consisting of Brad Simpson, James McVey, Connor Ball and Tristan Evans.", "ZVLQJMHHXTPCAPEVSS", "Vamps", "","ARMVKS","XOPOVL","XOLKORV"));


        allQuestions.add(new Questions("Who played the female lead in the film Passengers released in 2016 ?", "NELEAFSQNRENCWIREJ", "Jennifer", "Lawrence","ENRJCIEWN","RCAEFENLA","CA"));

        allQuestions.add(new Questions("Dev Patel and Nicole Kidman star in which film which tells the story of an Indian boy who gets lost on the streets of Calcutta and is adopted and later tries to find his family ?", "LTMLANOLRIXPTHNTLD", "Lion", "","DRHTLO","GNVIPL","VHDLGTRP"));

        allQuestions.add(new Questions("Which film of 2016 tells the factually based story of a team of African-American women mathematicians who played a vital role in the early years of the US space program ?", "HNEUDCYRIILNFSGEDF", "Hidden", "Figures","NSIDREEDF","HUEIAGHUL","AUHEL"));

        allQuestions.add(new Questions("\"Hey Mama\" is a song by which French DJ and record producer ?", "DVLLMGIITGTADMUAGE", "David", "Guetta","KXDVJDAUT","TATKGEITN","JTNKXKT"));

        allQuestions.add(new Questions("Which actor played Max Rockatansky in Mad Max: Fury Road (2015) ?", "HYTHMXRUMOROKAADWM", "Tom", "Hardy","MAENRYT","BNOWHOD","BWENON"));

        allQuestions.add(new Questions("\"Stay\" is a song by Russian-German electronic music producer Zedd and Canadian singer _________.", "ISWKLAMAAYBMAWERCS", "Alessia", "Cara","GAARXIACS","EAQHSCLCE","EGHCXCQ"));

        allQuestions.add(new Questions("\"Hymn for the Weekend\" is a song by which British rock band ?", "BLLYHAGLPFDCOZZZFD", "Coldplay", "","VDSOXLX","YLYACPL","LYVXSX"));

        allQuestions.add(new Questions("The title role of the 1900's movie, \"Pretty Woman\", was played by which actress ?", "IUBTASNRUJOLNETQRC", "Julia", "Roberts","RJKJLEEJI","TAROBNSUF","EJNFJK"));

        allQuestions.add(new Questions("In what year was the original \"Jurassic Park\" film released ?", "159852364178965893", "1993", "","159852","965893","58526589"));

        allQuestions.add(new Questions("Which horror movie character is a serial killer possessing a doll ?", "CRCBUFHCKWQLWRGYPC", "Chucky", "","MATCDXG","KHUZYCV","MTDZAVXG"));

        allQuestions.add(new Questions("\"Never Forget You\" is a song by Swedish singer ______ and British singer MNEK.", "SDRRMSAZLSXRROMAAN", "Zara", "Larsson","ZSAOLNQXQ","NKRRAASXP","NXQQXPK"));

        allQuestions.add(new Questions("In what movie, if you watch a certain video you'll die in 7 days ?", "RTXIVEDNZVYSWGREHQ", "The", "Ring","HPTBZRT","ENUGIHE","BTUPHEZ"));

        allQuestions.add(new Questions("In the movie Mean Girls, where is Caty originally from ?", "FCKZARARKPOXCAIFAJ", "Africa", "","RVSAVIY","ANFTKNC","YNKVTSVN"));

        allQuestions.add(new Questions("\"7 Years\" is a song by which Danish soul-pop band ?", "OUAKMMAABHAASRCLPG", "Lukas", "Graham","RASSKQAIM","EUGHLMTDA","QISTDME"));

        allQuestions.add(new Questions("\"Work from Home\" is a song recorded by which American girl group ?", "TRLOHHBBFAKIYYNQFM", "Fifth", "Harmony","NEOYHORFA","WFETSMIHD","ESWEDO"));

        allQuestions.add(new Questions("Starring Dwayne Johnson which film has as its backdrop a massive earthquake in California ?", "LAEBYCNCADNRNDSSDA", "San", "Andreas","AAANSSBD","GSBBREHN","SBBHBG"));

        allQuestions.add(new Questions("English actress starred in the 2015 film Sicario, she was also the female lead in 'Edge of Tomorrow'. Name her.", "FLBNUTHIMIEKYULNRC", "Emily", "Blunt","ELNITILV","PYULEUMB","UVILEP"));

        allQuestions.add(new Questions("What film stars both Amy Adams and Joaquin Phoenix ?", "HEOTKVKNQEGMREWEUA", "HER", "","PHCOD","RCCRE","RPCCDCO"));

        allQuestions.add(new Questions("What 2013 film stars Genesis Rodriguez and Paul Walker ?", "HUXSRBOZLOGQJXRQVC", "Hours", "","LDCSRO","VHFUSW","DWFLSVC"));

        allQuestions.add(new Questions("Who won the 88th Academy Awards' Best Actress award in 2016 ?", "XIPBENREALORILMRES", "Brie", "Larson","EFOUBLSR","FSIRIOAN","OFFSIU"));


        allQuestions.add(new Questions("Finish the title to this hit song recorded by Shakira for the 2016 Walt Disney film Zootopia - \"Try...\".", "ZHBGEZESVISITYMLNR", "Everything", "","RYJGZELI","OTVENVHZ","JVZLZO"));

        allQuestions.add(new Questions("Which 2016 science fiction film is based on the short story \"Story of Your Life\" by Ted Chiang ?", "HQIRPAGFSLXCORAKLV", "Arrival", "","GRFLEKV","IALERCA","CFEGLEK"));

        allQuestions.add(new Questions("Adam Richard Wiles, is a Scottish record producer, DJ, singer and songwriter known professionally  as ?", "CVRIUFIRHCSVALNCIA", "Calvin", "Harris","VIHHNMARW","VOSCRAVLI","VWOVMH"));

        allQuestions.add(new Questions("Skyscraper is the Song by which American singer, songwriter ?", "EIDHIHVMAOTCNDDOLP", "Demi", "Lovato","QTAVTEGL","MTODOJIR","GRQJTT"));

        allQuestions.add(new Questions("In Harry Potter, who plays Hagrid in the movie ?", "RNOUBLAEAOMEICBRDT", "Robbie", "Coltrane","CJREBNBOI","LETZLBOAR","JBZL"));

        allQuestions.add(new Questions("2016 American drama film centers on a family who are forced by circumstances to reintegrate into society after living in seclusion for a decade. Name the movie.", "NCAAICPTATSBTMIFNA", "Captai", "Fantastic","ATAFAACCS","ANMPTIKIT","MAK"));

        allQuestions.add(new Questions("Whats the name of the princess from the animated feature film ‘Brave’? ", "IXAEOXVDRMDPAZUOIS", "Merida", "","UMRGDKA","IMNWMEU","UWNGKUMM"));

        allQuestions.add(new Questions("Which movie won the Oscar for Best Animated Movie in the year 2014 ?", "JFIUTHERBIOZSNZQZD", "Frozen", "","RLFOYMU","NEZCBIO","OCIMBUYL"));

        allQuestions.add(new Questions("What famous musician was shot by Mark David Chapman in the year 1980 ?", "HALPKNNJSEMLNNOOSK", "John", "Lennon","KNJLONNE","NWHRXLNO","LNXWKR"));

        allQuestions.add(new Questions("Which X-Factor winner released the winner’s single 'When We Collide' ?", "EHDBLOAVATCATMLVRC", "Matt", "Cardle","CGAREBAL","DAKTTCMM","MABGCK"));

        allQuestions.add(new Questions("In the 1986 blockbuster \"Top Gun\" which actress played Goose's wife ?", "RASNUZGLKYAUGUUEQM", "Meg", "Ryan","NMMTKEN","RGAYTQJ","TNJQMTK"));

        allQuestions.add(new Questions("\"Hallelujah\" is a song written by which Canadian recording artist ?", "ENNEOYOFNLACJJHRPD", "Leonard", "Cohen","SPDODABNV","EHOLRCNXE","XSDBVP"));

        allQuestions.add(new Questions("Who directed the movie \"Reservoir Dogs\" ?", "PAIUAGNNTRTEQONINT", "Quentin", "Tarantino","NORENINAQ","TUATTURIN","UR"));

        allQuestions.add(new Questions("Which Teenage Mutant Ninja Turtle always wears red bandanas ?", "RSWLEPANSYDFJAELHW", "Raphael", "","QLHPERB","AHANYSO","BHNOQYS"));

        allQuestions.add(new Questions("Which actor played the main character in the 1990 film \"Edward Scissorhands\" ?", "YOPNDHEIPQJNEXHXXP", "Johnny", "Depp","FZPVYDSJ","NBEUHONP","FVBZUS"));

        allQuestions.add(new Questions("Who directed the movie \"Harry Potter and the Prisoner of Azkaban\" ?", "XLRONIASOUWOXÓNACF", "Alfonso", "Cuarón","NOKDRHSFA","ROÓLACUAN","RKDHA"));

        allQuestions.add(new Questions("What later \"Star Wars\" actress had an early role in the movie \"Léon: The Professional\" ?", "OANPINAAETUALNUMRT", "Natalie", "Portman","AULEROGHT","NTNPAIMAH","UHHG"));

        allQuestions.add(new Questions("In what year was Alfred Hitchcock's psychological thriller \"Psycho\" released ?", "091050985237803060", "1960", "","091050","062376","05023706"));

        allQuestions.add(new Questions("Which actress played identical twins in the 1998 movie remake of 'The Parent Trap' ?", "DHDRNOWSAYYLAGLINA", "Lindsay", "Lohan","HDGLYSOAZ","HYINOALZN","ZZOGYH"));

        allQuestions.add(new Questions("Tramar Lacel Dillard, is an American rapper known professionally as what ?", "IAARSQRFWDOOVFAFVL", "FLO", "RIDA","JQRHIYT","LRAOFHD","TJRQHHY"));


        this.addAllQuestions(allQuestions);
        /* Toast.makeText(context,"addquestions",Toast.LENGTH_SHORT).show();*/
    }

    /* private void addingeachquestions(Questions question) {
         ContentValues values = new ContentValues();
         values.put(QUESTION, question.getQUESTION());
         values.put(OPTION1, question.getOPT1());
         values.put(ANSWER, question.getANSWER());
         values.put(ANSWER2, question.getANSWER2());
         db = this.getWritableDatabase();
         db.insert(TABLE_NAME, null, values);
     }*/
    private void addAllQuestions(ArrayList<Questions> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (Questions question: allQuestions) {
                values.put(QUESTION, question.getQUESTION());
                values.put(OPTION1, question.getOPT1());
                values.put(ANSWER, question.getANSWER());
                values.put(ANSWER2, question.getANSWER2());
                values.put(RANDOMANS1, question.getRANDOMANS1());
                values.put(RANDOMANS2, question.getRANDOMANS2());
                values.put(USELESSSTRING, question.getUSELESSSTRING());
                db = this.getWritableDatabase();
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public List<Questions> getAllOfTheQuestions() {

        List<Questions> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String coloumn[] = {UID, QUESTION, OPTION1, ANSWER, ANSWER2, RANDOMANS1, RANDOMANS2,USELESSSTRING};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Questions question = new Questions();
            question.setID(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOpt1(cursor.getString(2));
            question.setAnswer(cursor.getString(3));
            question.setAnswer2(cursor.getString(4));
            question.setRANDOMANS1(cursor.getString(5));
            question.setRANDOMANS2(cursor.getString(6));
            question.setUSELESSSTRING(cursor.getString(7));
            questionsList.add(question);
        }
        cursor.close();
        db.close();
        return questionsList;
    }

    public void InsertQid(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CORRECTNO, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME2, null, contentValues);
       /* Toast.makeText(context,"the answer was correct"+id+"was added",Toast.LENGTH_SHORT).show();*/
        db.close();
    }

   public List GetQid() {
        String coloumns[] = {CORRECTNO};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME2, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list.add(questionId);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertHint(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(HINTID, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME3, null, contentValues);
        db.close();
    }

    public List getHint() {
        String coloumns[] = {HINTID};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME3, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int hintId = cursor.getInt(0);
            list.add(hintId);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertA1(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AONE, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME4, null, contentValues);
        db.close();
    }

    public List getA1() {
        String coloumns[] = {AONE};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME4, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int a1Id = cursor.getInt(0);
            list.add(a1Id);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertA2(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATWO, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME5, null, contentValues);
        db.close();
    }

    public List getA2() {
        String coloumns[] = {ATWO};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME5, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int a2Id = cursor.getInt(0);
            list.add(a2Id);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertA3(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATHREE, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME6, null, contentValues);
        db.close();
    }

    public List getA3() {
        String coloumns[] = {ATHREE};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME6, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int a3Id = cursor.getInt(0);
            list.add(a3Id);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertA4(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AFOUR, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME9, null, contentValues);
        db.close();
    }

    public List getA4() {
        String coloumns[] = {AFOUR};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME9, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int a4Id = cursor.getInt(0);
            list.add(a4Id);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void insertA5(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AFIVE, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME10, null, contentValues);
        db.close();
    }

    public List getA5() {
        String coloumns[] = {AFIVE};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME10, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int a5Id = cursor.getInt(0);
            list.add(a5Id);
        }
        cursor.close();
        db.close();
        return list;
    }

    //pause button of slider
    public void insertPauseValue(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(storePauseValue, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME11, null, contentValues);
        db.close();
    }

    public List getPauseButtonValue() {
        String coloumns[] = {storePauseValue};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME11, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int pauseValue = cursor.getInt(0);
            list.add(pauseValue);
        }
        cursor.close();
        db.close();
        return list;
    }

    //inserting and getting boom qid .
    public void insertBoom(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOM, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME12, null, contentValues);
        db.close();
    }

    public List getBoomId() {
        String coloumns[] = {BOOM};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME12, coloumns, null, null, null, null, null);
        List list = new ArrayList();
        while (cursor.moveToNext()) {
            int boomValue = cursor.getInt(0);
            list.add(boomValue);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void deleteAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.execSQL("delete from " + TABLE_NAME2);
        db.execSQL("delete from " + TABLE_NAME3);
        db.execSQL("delete from " + TABLE_NAME4);
        db.execSQL("delete from " + TABLE_NAME5);
        db.execSQL("delete from " + TABLE_NAME6);
       /* db.execSQL("delete from " + TABLE_NAME7);*/
        db.execSQL("delete from " + TABLE_NAME8);
        db.execSQL("delete from " + TABLE_NAME9);
        db.execSQL("delete from " + TABLE_NAME10);
        db.execSQL("delete from " + TABLE_NAME11);
        db.execSQL("delete from " + TABLE_NAME12);
        db.execSQL("delete from " + TABLE_NAME13);
        db.close();
    }

    public void optimiseDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.close();
    }

   /* public void InsertDollar(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DOLLAR, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME7, null, contentValues);
       *//* Toast.makeText(context,"the answer was correct"+id+"was added",Toast.LENGTH_SHORT).show();*//*
    }*/

  /*  public List getDollar() {
        String coloumns[] = {DOLLAR};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME7, coloumns, null, null, null, null, null);
        List list2 = new ArrayList();
        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        return list2;
    }*/

    public void InsertGems(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(GEMS, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME8, null, contentValues);
        db.close();
    }

   public List getGems() {
        String coloumns[] = {GEMS};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME8, coloumns, null, null, null, null, null);
        List list2 = new ArrayList();
        list2.add(150);
        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        cursor.close();
        db.close();
        return list2;
    }

    //Sound
    public void insertSound(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SOUND, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME13, null, contentValues);
        db.close();
    }

    public List getSound() {
        String coloumns[] = {SOUND};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME13, coloumns, null, null, null, null, null);
        List list2 = new ArrayList();
        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        cursor.close();
        db.close();
        return list2;
    }


}