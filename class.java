static class criteria_Weight
  {
    double CW_of_Energy_of_iot;
    double CW_of_Latency_of_iot;
    double CW_of_Computational_demand_of_iot;
    double CW_of_Energy_of_fog;
    double CW_of_deadline_of_fog;
  }
  //class for fog node ranking using AHP
  static class fogNode
  {
    int Id;
    double computational_power_of_fogNode;
    double power_of_fogNode;
    double deadline;
    double computational_demand;
    double energy;
    double inputSize;
    double weightage;
    double quota;

  }
  static class iotDevice
  {
    int Id;
    double computational_demand;
    double inputSize;
    double energy;
    double latency;
    double weightage;
    double dependency;
  }
  static class Binarycases
  {
    double energy;
    double total_time;
  }
