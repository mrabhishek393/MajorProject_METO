 public static fogNode[] fogpreference (double downlink_data_rate,
					 double uplink_data_rate,
					 double output_size)
  {
    fogNode[]fog;
    int number_of_fogNode;
    Scanner sc = new Scanner (System.in);	//System.in is a standard input stream  
    System.out.println ("Enter the number of fogNodes");
    int n = sc.nextInt ();
    fog = new fogNode[n];
    for (int i = 0; i < n; i++)
      {
	fog[i] = new fogNode ();
	fog[i].Id = i + 1;
	System.out.println ("enter the following for fog node:" + (i + 1));
	System.out.println ("power of fognode");
	fog[i].power_of_fogNode = sc.nextDouble ();
	System.out.println ("computational power  of fognode");
	fog[i].computational_power_of_fogNode = sc.nextDouble ();
	System.out.println ("deadline of fognode");
	fog[i].deadline = sc.nextDouble ();
	System.out.println ("inputSize of fognode in Kb");
	fog[i].inputSize = sc.nextDouble ();
	System.out.println ("computational_demand of fognode");
	fog[i].computational_demand = sc.nextDouble ();
	System.out.println ("enter quota of the fognde:: ");
	fog[i].quota = sc.nextDouble ();

	double upload_latency = fog[i].inputSize / (uplink_data_rate * 1000);
	double download_latency = output_size / (downlink_data_rate * 1000);
	double computational_latency =
	  (fog[i].computational_demand * fog[i].inputSize) / 50000;
	criteria_Weight cw = AHP ();
	fog[i].energy =
	  fog[i].power_of_fogNode * (upload_latency + download_latency) +
	  computational_latency * fog[i].computational_power_of_fogNode;
	fog[i].weightage =
	  cw.CW_of_Energy_of_fog * fog[i].energy +
	  cw.CW_of_deadline_of_fog * fog[i].deadline;

      }
    // sorting the fog nodes based on preference 
    for (int i = 0; i < n; i++)
      {
	for (int j = i + 1; j < n; j++)
	  {
	    if (fog[i].weightage < fog[j].weightage)
	      {
		fogNode temp = fog[i];
		fog[i] = fog[j];
		fog[j] = temp;
	      }
	  }
      }
    System.out.println ("order of the fog nodes are following\n");
    for (int i = 0; i < n; i++)
      {
	System.out.print (fog[i].Id + " ");
      }
    return fog;
  }
