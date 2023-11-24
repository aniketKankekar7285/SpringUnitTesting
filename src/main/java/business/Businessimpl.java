package business;

public class Businessimpl {

    public int calculateSum(int[] data)
    {
        int sum=0;
        for(int i=0;i<data.length;i++)
        {
            sum+=data[i];
        }
        return sum;
    }
}
