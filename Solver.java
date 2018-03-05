import java.io.*;
import java.util.ArrayList;

public class Solver {
    int [][] map;
    int rows = 0;
    int columns = 0;
    int vechicles;
    int rides;
    int bonus;
    int steps;
    int sizeOfArray;

    public Solver(String filename){
        calculate(filename);
        sizeOfArray = rows;
        sortStart(map,0,rows - 1);
    }

    public String solveIt(){

        //do sort
        int numOfCars = vechicles;

        ArrayList<Car> cars = new ArrayList<>();
        //
        for ( int i = 0; i < numOfCars; i++ )
        {
            cars.add( new Car() );
        }



        int numOfCarsDone = 0;


        while ( (numOfCarsDone < numOfCars) && (sizeOfArray > 0) )
        {
            for ( int i = 0; i < numOfCars; i++ )
            {
                if ( !cars.get(i).isDone() )
                {
                    int isPossible = cars.get(i).chooseRide( map, sizeOfArray );
                    if ( isPossible >= 0 )
                    {
                        // update 2d array
                        for ( int k = 0; k < sizeOfArray; k++ )
                        {
                            if ( map[k][6] == isPossible )
                            {
                                remove(k);
                            }
                        }
                    }

                }

            }
        }
        String s = "";
        for ( int i = 0; i < numOfCars; i++ )
        {
            Car car = cars.get(i);
            int ridesTotal = car.rides.size();
            if (  ridesTotal > 0 )
            {
                s += ridesTotal ;
                for (  int j = 0; j < ridesTotal; j++  )
                {
                    s += " " + car.rides.get(j) ;
                }
                s += "\n";
            }
        }

        return s;
    }

    public void remove(int k){
        for(int i = k; i < sizeOfArray-1; i++){
            map[i][0] =  map[i + 1][0];
            map[i][1] =  map[i + 1][1];
            map[i][2]   =  map[i + 1][2];
            map[i][3]   =  map[i + 1][3];
            map[i][4] =  map[i + 1][4];
            map[i][5] =  map[i + 1][5];
            map[i][6] =  map[i + 1][6];
        }
        sizeOfArray--;
    }

    public void calculate(String filename) {


        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            text = reader.readLine();
            int i,j = 0;
            for(i = 0; i < text.length(); i++ ){
                if(text.charAt(i) == 32){
                    rows = Integer.parseInt(text.substring(0, i));
                    j  = ++i;
                    break;
                }
            }
            for(; i < text.length(); i++){
                if(text.charAt(i) == 32){
                    columns = Integer.parseInt(text.substring(j, i));
                    j  = ++i;
                    break;
                }
            }
            columns =8;
            for(; i < text.length(); i++){
                if(text.charAt(i) == 32){
                    vechicles = Integer.parseInt(text.substring(j, i));
                    j  = ++i;
                    break;
                }
            }
            for(; i < text.length(); i++){
                if(text.charAt(i) == 32){
                    rides = Integer.parseInt(text.substring(j, i));
                    j  = ++i;
                    break;
                }
            }
            for(; i < text.length(); i++){
                if(text.charAt(i) == 32){
                    bonus = Integer.parseInt(text.substring(j, i));
                    j  = ++i;
                    break;
                }
            }

            steps = Integer.parseInt(text.substring(j, text.length()));
            rows = 0;
            while(true){
                text = reader.readLine();
                if(text == null){
                    break;
                }
                rows++;
            }
            reader = new BufferedReader(new FileReader(file));
            text = reader.readLine();
            // maxsize = Integer.parseInt(text.substring(j, text.length()));
            map = new int [rows][columns];
            int fillimi = 0;
            int index = 0;
            i = 0;
            for (i = 0; i < rows; i++){
                text = reader.readLine();
                for(j = 0, index = 0; j < text.length();j++){
                    if(text.charAt(j) == 32){
                        map[i][index] = Integer.parseInt(text.substring(fillimi,j ));
                        fillimi = ++j;
                        index++;
                    }

                }

                map[i][index] = Integer.parseInt(text.substring(fillimi, text.length()));
                index++;
                map[i][index] = i;
                index++;
                map[i][index] = -1;
                fillimi = 0;

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println();
            }
        }
    }

    public void merge(int arr[][], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[][] = new int [n1][7];
        int R[][] = new int [n2][7];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i][4] <= R[j][4])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sortStart(int arr[][], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortStart(arr, l, m);
            sortStart(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}

