package view;

/**
* Taget fra: http://www.eksperten.dk/spm/234580
* Dato: 06/12-14
* Lavet af brugeren Reinke.
*/
public class CprValidate  {
    
    /**
     *This method is use to validate a inserted cprTF in CreateMemberGUI
     * @param cpr
     * @return a boolean 
     */
    public static boolean validateCpr(String cpr)
    {
        //Hvis cpr er tomt eller længden på cpr ikke er 10 skal den returner false.
        if(cpr==null || cpr.length()!=10) return false;
        //Konvertere String cpr til en my char array der hedder cprArray.
        char[] cprArray=cpr.toCharArray();
        //Denne for løkke går igennem char arrayet, char for char.
        for(int x=0;x<cprArray.length;x++)
        {
            //Denne if løkke tjekker vis de indtastet char i cprArray er digitalt eller returner den false.
            if(!Character.isDigit(cprArray[x])) return false;
            cprArray[x]-='0'; // <-- ????
        }
        /*Det er nogle vægte som bruges i den 11 tværsums regel man bruger til at
        validere CPR nummeret med.
        11 skal gå op i summen af vægte * cifre */
        char[] talArray={4,3,2,7,6,5,4,3,2,1};
        
        //Denne del er metoden er selve tjekket for at det er en gyldig cpr. Da den her går igennem alle 10 cifre og da vi ganger talArray med cprArray of for hve gang bliver summet et højere op til 9.
        
        int sum=0;
        for(int x=0;x<10;x++)
        {
            sum+=cprArray[x]*talArray[x];
        }

        if((sum%11)!=0) return false;
        return true;
}
    
}


