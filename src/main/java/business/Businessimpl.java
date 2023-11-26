package business;

import data.dataService;

public class Businessimpl {

    private dataService somedataservice;
    public void setSomedataservice(dataService somedataservice) {
        this.somedataservice = somedataservice;
    }

    public int calculateSum(int[] data)
    {
        int sum=0;
        for(int i=0;i<data.length;i++)
        {
            sum+=data[i];
        }
        return sum;
    }



    public int calculateSum_usingDataService(){
        Businessimpl business =new Businessimpl();
        int[] data= somedataservice.retriveAllData();
        int sum=0;
        for(int val:data){
            sum+=val;
        }
        return sum;
    }
}
