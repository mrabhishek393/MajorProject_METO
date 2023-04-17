 public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    //taking all required inputs
    System.out.println ("please provide the following inputs::\n");
    System.
      out.println ("enter the computational demand of the task in million::");
    double computational_demand = sc.nextDouble ();
    System.out.println ("enter frequency in megahertz::");
    double frequency = sc.nextDouble ();
    System.out.println ("enter channer frequency(bandwidth) in megahetz::");
    double bandwidth = sc.nextDouble ();
    System.
      out.println ("enter Distance of IOT device to fog node in meter::");
    int distance_to_fog_node = sc.nextInt ();
    System.out.println ("enter the power of iot device in watts::");
    double power_of_iot_device = sc.nextDouble ();
    System.out.println ("enter the power of fog node in watts :: ");
    double power_of_fogDevice = sc.nextDouble ();
    System.out.println ("enter the output size in Kb::");
    double output_size = sc.nextDouble ();
    System.out.println ("enter the computational power of fog node::");
    double computational_power_of_fognode = sc.nextDouble ();

    System.out.println ("enter the value of X::");
    double X = sc.nextDouble ();
    System.out.println ("enter the value of S::");
    double S = sc.nextDouble ();
    System.out.println ("enter the value of N::");
    double N = sc.nextDouble ();


    double local_execution_time = computational_demand / frequency;
    System.out.println ("local execution time is:: " + local_execution_time +
			"\n");



    double log10distance_to_fog_node = log10 (distance_to_fog_node);

    double PLIJ = 38.02 + 20 * log10distance_to_fog_node;
    //   System.out.println(PLIJ);
    double power_to_calculate = -(PLIJ / 10);
    double channel_gain = Math.pow (10, power_to_calculate);

    double noise_power = Math.pow (10, -10);

    double in_the_log =
      1 + (power_of_iot_device * channel_gain) / noise_power;

    double log2in_the_log = log2 (in_the_log);
    double uplink_data_rate = bandwidth * log2in_the_log;

    System.out.println ("uplink data rate is in megahetz :: " +
			uplink_data_rate + "\n");

    double downlink_data_rate =
      bandwidth * log2 (1 +
			(power_of_fogDevice * channel_gain) / noise_power);
    System.out.println ("downlink  data rate is in megahetz :: " +
			downlink_data_rate + "\n");
    double Energy_of_IOT_device = power_of_iot_device * local_execution_time;
    System.out.println ("enery of iot device is in joule :: " +
			Energy_of_IOT_device + "\n");
    double computational_capacity_of_one_fognode = 50000;
    double Iij = 300;

    double computational_delay =
      (computational_demand * Iij) / (computational_capacity_of_one_fognode);

    double uplink_data_rate_time = output_size / (uplink_data_rate * 1000);
    double downlink_data_rate_time =
      output_size / (downlink_data_rate * 1000);



    //calling function to rank fognodes 
    fogNode[]fog;
    iotDevice[]iot;
    //calling fog preferrence to get the order of fog nodes 
    fog = fogpreference (downlink_data_rate, uplink_data_rate, output_size);
    //calling iot preferrence to get the order of iot devices
    iot =
      iotpreference (local_execution_time, uplink_data_rate_time,
		     downlink_data_rate_time, power_of_iot_device,
		     power_of_iot_device, computational_power_of_fognode,
		     computational_delay, X, S, N, power_of_fogDevice,
		     downlink_data_rate, uplink_data_rate, output_size);
    MatchingAlgo (iot, fog);








  }