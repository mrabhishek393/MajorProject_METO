  public static Binarycases both_locally_executed (double
						   local_execution_time,
						   double uplink_time,
						   double downlink_time,
						   double power_of_iotd1,
						   double power_of_iotd2,
						   double
						   computational_power_of_fognode,
						   double computational_delay,
						   double X, double S,
						   double N,
						   double power_of_fogDevice)
  {
    double total_time =
      2 * local_execution_time + uplink_time + downlink_time;
    double total_energy =
      power_of_iotd1 * (local_execution_time) +
      power_of_iotd2 * (local_execution_time) + (uplink_time +
						 downlink_time) *
      power_of_fogDevice;

    double computation_time_for_iotd1 =
      (uplink_time + computational_delay) * (X - 1);
    double computation_time_for_iotd2 =
      (uplink_time + computational_delay) * (S - 1);
    double remaining_time = (uplink_time + computational_delay) * (N - S);
    double waiting_time =
      Math.max (computation_time_for_iotd1, computation_time_for_iotd2);
    total_energy =
      total_energy + (X - 2 +
		      N) * (computational_power_of_fognode *
			    computational_delay +
			    power_of_fogDevice * (uplink_time +
						  downlink_time));

    total_time = total_time + remaining_time + waiting_time;
    Binarycases bn = new Binarycases ();
    bn.total_time = total_time;
    bn.energy = total_energy;

    System.out.println ("CASE 1: both tasks are executed locally!!");
    // System.out.println("total time is:: "+total_time);
    //     System.out.println("total energy is:: "+total_energy+"\n");
    return bn;

  }

  //function for device 1 on fog node and 2 local execution
  public static Binarycases first_onfog_second_locally (double
							local_execution_time,
							double uplink_time,
							double downlink_time,
							double power_of_iotd1,
							double power_of_iotd2,
							double
							computational_power_of_fognode,
							double
							computational_delay,
							double X, double S,
							double N,
							double
							power_of_fogDevice)
  {
    double total_time =
      local_execution_time + uplink_time + downlink_time +
      computational_delay;
    double total_energy =
      power_of_fogDevice * (uplink_time + downlink_time) +
      computational_power_of_fognode * computational_delay +
      power_of_iotd2 * (local_execution_time);
    double computation_time_for_iotd1 =
      (uplink_time + computational_delay) * (X - 1);
    double computation_time_for_iotd2 =
      (uplink_time + computational_delay) * (S - 1);
    double remaining_time = (uplink_time + computational_delay) * (N - S);
    double waiting_time =
      Math.max (computation_time_for_iotd1, computation_time_for_iotd2);
    total_energy =
      total_energy + (X - 2 +
		      N) * (computational_power_of_fognode *
			    computational_delay +
			    power_of_fogDevice * (uplink_time +
						  downlink_time));


    total_time = total_time + remaining_time + waiting_time;
    Binarycases bn = new Binarycases ();
    bn.total_time = total_time;
    bn.energy = total_energy;
    System.out.println ("CASE 2: iotd1 execute at fog and d2 locally!!");
    // System.out.println("total time is:: "+total_time);
    //     System.out.println("total energy is:: "+total_energy+"\n");
    return bn;

  }

  //function for task 1 local execution(on iotd1) and  task 2 on fog node
  public static Binarycases first_locally_second_onfog (double
							local_execution_time,
							double uplink_time,
							double downlink_time,
							double power_of_iotd1,
							double power_of_iotd2,
							double
							computational_power_of_fognode,
							double
							computational_delay,
							double X, double S,
							double N,
							double
							power_of_fogDevice)
  {
    double total_time =
      local_execution_time + 2 * uplink_time + computational_delay;
    double total_energy =
      (2 * uplink_time * power_of_fogDevice) +
      computational_delay * computational_power_of_fognode +
      power_of_iotd1 * (local_execution_time);
    double computation_time_for_iotd1 =
      (uplink_time + computational_delay) * (X - 1);
    double computation_time_for_iotd2 =
      (uplink_time + computational_delay) * (S - 1);
    double remaining_time = (uplink_time + computational_delay) * (N - S);
    double waiting_time =
      Math.max (computation_time_for_iotd1, computation_time_for_iotd2);
    total_energy = total_energy + (X - 2 + N) * (computational_power_of_fognode * computational_delay + power_of_fogDevice * (uplink_time + downlink_time));	//X and Sth task are dependent so X-1+S-1+Y-S will be remaining task that is X-2+N

    total_time = total_time + remaining_time + waiting_time;
    Binarycases bn = new Binarycases ();
    bn.total_time = total_time;
    bn.energy = total_energy;
    System.out.println ("CASE 3: iotd1 execute locally and d2 at fog!!");
    // System.out.println("total time is:: "+total_time);
    //     System.out.println("total energy is:: "+total_energy+"\n");

    return bn;
  }
  //both execute on fog node (iotd1 and iotd2)
  public static Binarycases both_onfog (double local_execution_time,
					double uplink_time,
					double downlink_time,
					double power_of_iotd1,
					double power_of_iotd2,
					double computational_power_of_fognode,
					double computational_delay, double X,
					double S, double N,
					double power_of_fogDevice)
  {
    double total_time = 2 * uplink_time + 2 * computational_delay;
    double total_energy =
      computational_power_of_fognode * (2 * uplink_time +
					2 * computational_delay);
    double computation_time_for_iotd1 =
      (uplink_time + computational_delay) * (X - 1);
    double computation_time_for_iotd2 =
      (uplink_time + computational_delay) * (S - 1);
    double remaining_time = (uplink_time + computational_delay) * (N - S);
    double waiting_time =
      Math.max (computation_time_for_iotd1, computation_time_for_iotd2);
    total_energy =
      total_energy + (X - 2 +
		      N) * (computational_power_of_fognode *
			    computational_delay +
			    power_of_fogDevice * (uplink_time +
						  downlink_time));


    total_time = total_time + remaining_time + waiting_time;
    Binarycases bn = new Binarycases ();
    bn.total_time = total_time;
    bn.energy = total_energy;
    System.out.println ("CASE 4: iotd1 and d2 both execute at fog!!");
    // System.out.println("total time is:: "+total_time);
    //     System.out.println("total energy is:: "+total_energy+"\n");

    return bn;
  }
