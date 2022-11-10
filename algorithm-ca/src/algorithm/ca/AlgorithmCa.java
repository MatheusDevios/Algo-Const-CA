/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class AlgorithmCa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String file = "path to the file\\MOCK_DATA.csv";     //I have put this here so we can change it easily if we need to!
        
            try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store da
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
    
}
