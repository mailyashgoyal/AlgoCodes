import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class mainClass {

	//once 100000 customers depart from the system.
	public static void main(String arg[]) throws IOException
	{
		EventList Elist ;                // Create event list
		//public enum ABC {ARR,DEP};                 // Define the event types
		int ARR =0;
		int DEP =1;
		int ARRL =2;
		int ARRG =3;
		double clock = 0.0;             // System clock
		int N = 0;                      // Number of customers in system
		int Ndep = 0;                   // Number of departures from system
		double UtilizationSimulation = 0.0;
		double EN = 0.0;                // For calculating E[N]

		Integer done = 0;                   // End condition satisfied?

		Event CurrentEvent;
		rv rr = new rv();
		double Terminals = 0.0;
		double K = 0.0; // Maximum Capacity Size
		double m = 0.0; // Number of servers available
		double blocked = 0.0; // To track number of Blocked customers

		double lambda = 0.0; // Arrival rate
		double gaama = 0.0 ;// arrival rate for first machine
		double mu = 4; // Service rate
		double Arrivals=0;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
		String sentence = null;

		/*System.out.println("Enter the number of terminals ( value 10 used for simulation )");
		sentence = null;
		sentence = inFromUser.readLine(); 
		Terminals = Double.parseDouble(sentence);
*/
		System.out.println("Enter the number of servers 2");
		sentence = null;
		sentence = inFromUser.readLine(); 
		m = Double.parseDouble(sentence);

//		int maxNumofCpus = (int) m ;


		System.out.println("Enter the value of k 4");
		sentence = null;
		sentence = inFromUser.readLine(); 
		K = Double.parseDouble(sentence);

		System.out.println("Enter the mu value 3");
		sentence = null;
		sentence = inFromUser.readLine(); 
		mu = Double.parseDouble(sentence);
		/*
		System.out.println("Enter the lambda (From 0.1 to 1.0 )");
		sentence = null;
		sentence = inFromUser.readLine(); 
		lambda = Double.parseDouble(sentence);
		 */
		System.out.println("Enter the gamma 5");
		sentence = null;
		sentence = inFromUser.readLine(); 
		gaama = Double.parseDouble(sentence);
		//gaama = 5;
		//int x = (int) Terminals ; // To track the blocked terminal
		//int z = (int) (K-m); // z is queue Size
		//int maxQueueSize = z ;

		// for tracking number of terminals

		//int i = (int) Terminals ;

		double rho = 0.0;
		for (int i = 0 ; i < 10 ; i++)   // This loop runs for 10 times which is used for generating simulated values for diff values of rho
		{
			rho += 0.1;  // Increment rho in steps of 0.1
			// Reinitialization of the all the variables used in the previous loop
			// cout << " Doing Reinitialization " << endl;
			// EventList.clear();
			//Event it_ListBegin = null; // Begin Iterator     
			//Event it_ListEnd = null;  // End iterator
			Elist = new EventList();
			lambda = 0.0 ;                 // Machine 2 Arrival rate
			clock = 0.0;             // System clock
			EN = 0.0;                // Avg number of customers in systems
			//double ET = 0.0;                // Avg time spent in the system.
			N = 0;                   // Number of customers in system
			Ndep = 0;                // Number of departures from system
			double NArr = 0;                // Number of arrivals into the System.
			double NBlock = 0;              // Number of blocked customers
			double Util = 0.0;              // utilization
			int Flag = 0;                // loop variable

			lambda = (rho * m * mu);  // calculation the value fo lambda

			System.out.println(" The value of Lambda is " + lambda);
			System.out.println(" The value of MU is " + mu);
			System.out.println(" The value of RHO is " + rho);

			Elist.insert(rr.exp_rv(lambda),ARRL);// Generate first arrival event for machine 1
			Elist.insert(rr.exp_rv(gaama),ARRG);//Generate first arrival event for machine 2

			while (Flag != 1)   // loop which runs this the flag becomes true
			{
				double prev = clock;                            // Store old clock value
				Event E = Elist.get();              // Get next Event from list
				clock = E.time;                 // Update system clock 
				switch (E.type) 
				{
				case 2:                                 // If arrival is from machine 2

					EN += N*(clock - prev);             //  update system statistics
					NArr++;                            // update number of arrivals
					if((N > 0 ) && (N < m))            // if number of customes in system less than number of servers
						Util += ((N/m)*(clock - prev));    // servers utilization is less than 1
					else if (N >= m)                   // if number of customes in system is greater that number of servers
						Util += (clock - prev);            // servers utilization is 1

					if(N >= K)                           // if number of customers in system more than capacity
					{
						NBlock++;                      // The number of customers blocked will be incremented
						Elist.insert(rr.exp_rv(lambda),ARRL);           //  generate next arrival             
						break;
					}              

					N++;     // update number of customers   
					Elist.insert(clock+rr.exp_rv(lambda),ARRL);                 //  generate next arrival                         

					if(N <= m ) // if number of customers are less than  servers ,  server is idle so generate a departure event. 
					{
						Elist.insert(clock+rr.exp_rv(mu),DEP);               //  generate departure    
					}                   

					break;

				case 3:  
					EN += N*(clock - prev);  //  update system statistic

					if((N > 0 ) && (N < m))
						Util += ((N/m)*(clock - prev));
					else if(N >= m)
						Util += (clock - prev);


					if(N >= 2)     // if number of customers greater are two or more the arrival event is ignored
					{
						Elist.insert(clock+rr.exp_rv(gaama),ARRG);                //  generate next arrival  
						break;
					}

					N++;   // update number of customers in system
					NArr++;    // update number of arrivals in system  

					//E.type = ARRG;    
					//E.time = clock + rr.exp_rv(lambda+ gaama);   // The arrival rate will be lamba + gaama                         
					Elist.insert(clock+rr.exp_rv(gaama),ARRG);                 //  generate next arrival  
					if(N <= m ) // if number of customers are less than  servers , means server idle so generate a departure event.
					{
						Elist.insert(clock+rr.exp_rv(mu),DEP);                //  generate departure    
					}        
					break;

				case 1:                                 // If departure evernt occurs

					EN += N*(clock-prev);                   //  update system statistics
					if((N > 0 ) && (N < m))
						Util += ((N/m)*(clock - prev));
					else if(N >= m)
						Util += (clock - prev);
					N--;                  //  decrement system size                    
					Ndep++;               //  increment num. of departures

					if (N >= m)          // If no of customers is either 2 or 3 or 4 then the rate with be MU
					{
						Elist.insert(clock+rr.exp_rv(mu),DEP);                //  generate next departure
					} 
					break;
				}  // end of switch

				E= E.next;
				//Elist.remove(E.type);    // delete the event in the list
				// EventList.sort(compare);                // Sort the list in increasing order         
				if (Ndep > 100000) {Flag=1;}// End condition
			}  // end of while


			System.out.println("Expected number of customers (simulation): " + EN/clock);
			System.out.println(" Expected time customers spent in system (simulation): " + EN/Ndep);
			System.out.println("Blocking Probability is given as " + NBlock/NArr);
			System.out.println(" utilization is given as " + Util/clock);
		}


		/*
		while(i > 0)
		{
			if ((x > 0))
			{
				if((x <= Terminals ))
				{
					Elist.insert(clock+rr.exp_rv(lambda),ARR); // Generate first arrival event
					x -- ;
				}
			}
			i -- ;
		}

		while (done != 1)
		{
			CurrentEvent = Elist.get();               // Get next Event from list
			double prev = clock;                      // Store old clock value
			clock=CurrentEvent.time;                 // Update system clock 

			switch (CurrentEvent.type)
			{

			case 0:
				EN += N*(clock-prev);                   //  update system statistics

				if(N < maxNumofCpus)  // For calculating Utilization
				{
					UtilizationSimulation += (N*(clock-prev))/maxNumofCpus;
				}
				else
				{
					UtilizationSimulation += (maxNumofCpus*(clock-prev))/maxNumofCpus;
				}

				if (m > 0) // if server is free
				{
					Arrivals++ ; // to track number of arrivals
					N++;	//  update system size
					m = m -1 ;    //  add the event to the system in server n decrease the number of servers available
					Elist.insert(clock+rr.exp_rv(mu),DEP); //generate a departure event for the new arrival
				}
				else if (z>0) // if queue is free
				{
					Arrivals++ ; // to track number of arrivals
					N++ ; //  update system size
					z-- ; // Decrease queue Size
				}
				else // otherwise Blocked
				{
					Arrivals++ ;
					blocked ++ ;
					x ++ ; // Free the terminal

					// In blocking state also the customers terminal will be free
					if ((x > 0))
					{
						if((x <= Terminals ))
						{
							Elist.insert(clock+rr.exp_rv(lambda),ARR); // Generate first arrival event
							x -- ;  // Block again terminal
						}
					}
				}
				break;
			case 1:
				// If departure
				EN += N*(clock-prev);                               //  update system statistics
				if(N<maxNumofCpus)
				{
					UtilizationSimulation += (N*(clock-prev))/maxNumofCpus;
				}
				else
				{
					UtilizationSimulation += (maxNumofCpus*(clock-prev))/maxNumofCpus;
				}

				N--;                                         //  decrement system size
				m = m +1;								     //  Free the CPU in Departure case as well
				x ++ ;									     //  Free the terminal
				Ndep++;                                      //  increment num. of departures

				if ((m > 0 ) && (z < maxQueueSize)) 	     //  Check is servers are available and there is something in Queue
				{
					m = m - 1;							     //  Decrease the available servers
					z = z + 1 ; 						     //  Increase the Queue Size because server the event is now send to server
					Elist.insert(clock+rr.exp_rv(mu),DEP);   //  generate next departure

				}

				// To free a Terminal
				if ((x > 0))
				{
					if((x <= Terminals ))
					{
						Elist.insert(clock+rr.exp_rv(lambda),ARR);  // Generate  arrival event
						x -- ;
					}
				}
				break;
			}
			CurrentEvent = null;
			//delete CurrentEvent;
			if (Ndep > 100000)
				done=1;      								  // End condition
		}
		 */
		System.out.println("Simulation "); ;
		System.out.println("Average number of jobs      " + EN/clock );
		double averageTimeSpend = EN/(Ndep);
		System.out.println("AverageTimeSpend            " + averageTimeSpend );
		System.out.println("Utilization :               " + (UtilizationSimulation)/(clock));
		System.out.println("Blocking Probabililty :     " + blocked/Arrivals );


		System.out.println(" ");
		System.out.println("Theoretical Values");

		double theoLambda = 0.0;  // rate of arrivals for machine 2
		double theoGaama = 5;     // rate of arrivals for machine 1
		double theoMU= 4;         // service rate of both the machines
		double theoM = 2;         // number of servers
		double theoEN = 0.0;      // Expected number of customers
		double theoET = 0.0;      // Expected time spent by customers
		double theoEffLambda = 0.0;  // Effective arrival rate
		double theoRho = 0.0;        // Rho value
		double theoPBlock = 0.0;   // probability of blocking
		double theoUtil = 0.0;     // utilization of servers
		double p0 = 0.0;       // probability of being in state 0
		double p1 = 0.0;       // probability of being in state 1
		double p2 = 0.0;       // probability of being in state 2
		double p3 = 0.0;       // probability of being in state 3
		double p4 = 0.0;       // probability of being in state 4


		for(int q = 0; q < 10 ; q++)    // loop iterates for times will value of rho increment in steps of 0.1
		{
			theoRho += 0.1;    // rho increments in steps of 0.1
			theoLambda = (theoRho * theoM * theoMU);  // value of lambda calculated

			System.out.println("Theortical Rho  Value:::::::::::" + theoRho);
			System.out.println("Theortical M  Value:::::::::::" + theoM);
			System.out.println("Theortical Lambda  Value:::::::::::" + theoLambda);

			p1 = (theoLambda + theoGaama)/theoMU;  // Equation for probability of being in state 1
			p2 = ((theoLambda + theoGaama) * (theoLambda + theoGaama))/(2* Math.pow(theoMU,2)); // Equation for probability of being in state 2
			p3 = ((theoLambda + theoGaama) * (theoLambda + theoGaama)* theoLambda)/(4* Math.pow(theoMU,3));// Equation for probability of being in state 3
			p4 = ((theoLambda + theoGaama) * (theoLambda + theoGaama)* theoLambda * theoLambda)/(8* Math.pow(theoMU,4)); // Equation for probability of being in state 4

			p0 = 1 / (1+p1+p2+p3+p4) ;  // using therom of total probability the value of p0 is calculated    

			p1 = p1 * p0;  // value of p1
			p2 = p2 * p0;  // value of p2
			p3 = p3 * p0;  // value of p3
			p4 = p4 * p0;  // value of p4 

			theoEN = (1 * p1) + (2 * p2) + (3 * p3) + (4 * p4); // Expected number of customers

			theoEffLambda = ((theoLambda + theoGaama) * p0) + ((theoLambda + theoGaama) * p1) + (theoLambda  * p2) + (theoLambda  * p3) ;  // calculation fo effective lambda

			theoET =  theoEN / theoEffLambda;   // Expected time spent by the customers
			/*Probability of customer being blocked*/
			theoPBlock = (theoLambda * p4) / (((theoLambda + theoGaama) * p0) + ((theoLambda + theoGaama) * p1) + (theoLambda  * p2) + (theoLambda  * p3) +(theoLambda  * p4) );
			theoUtil = (0.5 * p1) + ( p2) + (p3) + (p4); // Total Utilization of the system
			System.out.println("TheorticalEnValue:::::::::::" + theoEN);
			System.out.println("TheorticalAverageTime:::::::" + theoET);
			System.out.println("TheorticalUtilization:::::::" + theoUtil);
			System.out.println("TheorticalBlockingProb::::::" +theoPBlock);
		}  
		/*
		double a = 0.0 ; // po
		double b = 0.0 ; // p1
		double c = 0.0 ; // p2
		double d = 0.0 ; // p3
		double e = 0.0 ; // p4

		double temp1 = (10*lambda)/mu;
		double temp2 = (45*lambda*lambda)/(mu*mu);
		double temp3 = (180*lambda*lambda*lambda)/(mu*mu*mu);
		double temp4 = (630*lambda*lambda*lambda*lambda)/(mu*mu*mu*mu);

		double temp5 = 1 + temp1 + temp2 + temp3 + temp4 ;

		a = 1/temp5; // po
		b = temp1*a; // p1
		c = temp2*a; // p2
		d = temp3*a; // p3
		e = temp4*a; // p4

		// Printing the theortical probabilities value

		System.out.println("The value of po is ::: " + a );
		System.out.println("The value of p1 is ::: " + b );
		System.out.println("The value of p2 is ::: " + c );
		System.out.println("The value of p3 is ::: " + d );
		System.out.println("The value of p4 is ::: " + e );

		double TheoritacalEnValue = (1*b) + (2*c) +(3*d) +(4*e) ;
		System.out.println("TheorticalEnValue:::::::::::" + TheoritacalEnValue);

		double lambdaEffecfive = (10*lambda*a)+(9*lambda*b)+(8*lambda*c)+(7*lambda*d);
		System.out.println("TheorticalAverageTime:::::::" + (TheoritacalEnValue/lambdaEffecfive));

		double TheoritacalUtilization = (0.5*b)+c+d+e;
		System.out.println("TheorticalUtilization:::::::" + TheoritacalUtilization);

		double TheoriticalBlockingProb = 0.0 ;
		TheoriticalBlockingProb = (6*lambda*e)/((10*lambda*a)+(9*lambda*b)+(8*lambda*c)+(7*lambda*d)+(6*lambda*e));
		System.out.println("TheorticalBlockingProb::::::" +TheoriticalBlockingProb);
		 */
	}
}
