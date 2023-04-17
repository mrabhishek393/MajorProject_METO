  public static void MatchingAlgo (iotDevice[]iot, fogNode[]fog)
  {
    //we are implementing one to many like every iot task will be having multiple options to go 
    int total_number_of_iot_tasks = iot.length;
    //storing the matching of iot, fog 
    int total_number_of_fog_nodes = fog.length;
    HashMap < Integer, Integer > matching =
      new HashMap < Integer, Integer > ();
    //to check weatrher the task went to any fog device or any fog assigned or not to that particular task
    int flag = 0;
    for (int i = 0; i < total_number_of_iot_tasks; i++)
      {
	flag = 0;		//reinitializing the flag 0 to track again

	for (int j = 0; j < total_number_of_fog_nodes; j++)
	  {
	    if (fog[j].quota >= iot[i].dependency)
	      {
		fog[j].quota = fog[j].quota - iot[i].dependency;
		matching.put (iot[i].Id, fog[j].Id);
		flag = 1;	//to track that is the iot task assigned to a fog node or node


	      }
	    if (flag == 1)	//if task is assigned according to preference then breaking the loop and going on next task
	      break;

	  }
	if (flag == 0)
	  {
	    matching.put (iot[i].Id, -1);
	  }
      }





    //printing pairs of HashMap
    System.out.println ("printing matched iot fog pair ...");
  for (Map.Entry m:matching.entrySet ())
      {
	if ((Integer) m.getValue () != -1)	//if none of the fog node is assigned then  it will go in the else case 
	  System.out.println ("iot task number " + m.getKey () +
			      " is matched with " +
			      "fog node " + m.getValue ());
	else
	  System.out.println ("iot task number" + m.getKey () +
			      " is not matched with any fog node due to busyness of fog nodes");
      }


  }