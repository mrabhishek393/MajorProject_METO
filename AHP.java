  public static criteria_Weight AHP ()
  {
    criteria_Weight cw = new criteria_Weight ();

    //for fog node 
    //oth row/column energy
    //1st row/column latency
    //2nd  row/column computational demand
    //for fog node 
    double sum = 0;
    int n = 3;
    //for fog node
    double[][] standard_matrix = { {1.0, 4.0, 5.0},
    {0.25, 1.0, 3.0},
    {0.2, 0.33, 1.0}
    };
    //step one to calculate C.W.
    double[][] matrix_for_CW = new double[n][n];
    for (int i = 0; i < n; i++)
      {
	sum = 0;
	for (int j = 0; j < n; j++)
	  {
	    sum = sum + standard_matrix[j][i];

	  }
	for (int j = 0; j < n; j++)
	  {
	    matrix_for_CW[j][i] = standard_matrix[j][i] / sum;
	  }

      }

    //since first is energy then latency then computational demand
    sum = 0;

    for (int i = 0; i < n; i++)
      {
	sum = sum + matrix_for_CW[0][i];
      }

    cw.CW_of_Energy_of_iot = sum / n;
    sum = 0;
    for (int i = 0; i < n; i++)
      {
	sum = sum + matrix_for_CW[1][i];
      }
    cw.CW_of_Latency_of_iot = sum / n;
    sum = 0;
    for (int i = 0; i < n; i++)
      {
	sum = sum + matrix_for_CW[2][i];
      }
    cw.CW_of_Computational_demand_of_iot = sum / n;



    //matrix for WS 
    double[][] matrix_for_WS = new double[n][n];
    //defining variables for weighted sum accordingly
    double weighted_sum_of_energy = 0;
    double weighted_sum_of_latency = 0;
    double weighted_sum_of_computational_demand = 0;
    sum = 0;
    for (int i = 0; i < n; i++)
      {
	matrix_for_WS[i][0] = cw.CW_of_Energy_of_iot * standard_matrix[i][0];

      }
    for (int i = 0; i < n; i++)
      {
	matrix_for_WS[i][1] = cw.CW_of_Latency_of_iot * standard_matrix[i][1];

      }
    for (int i = 0; i < n; i++)
      {
	matrix_for_WS[i][2] =
	  cw.CW_of_Computational_demand_of_iot * standard_matrix[i][2];

      }

    //calculating weighted sum for all
    sum = 0;

    for (int i = 0; i < n; i++)
      {
	weighted_sum_of_energy = weighted_sum_of_energy + matrix_for_CW[0][i];
      }

    for (int i = 0; i < n; i++)
      {
	weighted_sum_of_latency =
	  weighted_sum_of_latency + matrix_for_CW[1][i];
      }

    for (int i = 0; i < n; i++)
      {
	weighted_sum_of_computational_demand =
	  weighted_sum_of_computational_demand + matrix_for_CW[2][i];
      }

    double Energy_ratio = weighted_sum_of_energy / cw.CW_of_Energy_of_iot;

    double Latency_ratio = weighted_sum_of_latency / cw.CW_of_Latency_of_iot;
    double Computational_demand_ratio =
      weighted_sum_of_computational_demand /
      cw.CW_of_Computational_demand_of_iot;
    double lambda_max =
      (Energy_ratio + Latency_ratio + Computational_demand_ratio) / 3;
    double CI = (lambda_max - n) / (n - 1);
    double CR = CI / 0.58;	//random index is 0.58 for n=3;
    if (CR < 0.10)
      {
	System.out.println ("Matrix is consistent");
      }

    //cw for iot device
    //oth row/column energy
    //1st row/column deadline
    double[][] standard_matrix_for_iot = { {1.0, 5.0},
    {0.2, 1.0}
    };
    n = 2;
    double[][] matrix_for_CW_of_iot = new double[n][n];
    for (int i = 0; i < n; i++)
      {
	sum = 0;
	for (int j = 0; j < n; j++)
	  {
	    sum = sum + standard_matrix_for_iot[j][i];

	  }
	for (int j = 0; j < n; j++)
	  {
	    matrix_for_CW_of_iot[j][i] = standard_matrix_for_iot[j][i] / sum;
	  }

      }
    sum = 0;
    for (int i = 0; i < n; i++)
      {
	sum = sum + matrix_for_CW_of_iot[0][i];
      }

    cw.CW_of_Energy_of_fog = sum / n;
    sum = 0;
    for (int i = 0; i < n; i++)
      {
	sum = sum + matrix_for_CW_of_iot[1][i];
      }
    cw.CW_of_deadline_of_fog = sum / n;

    return cw;


  }
