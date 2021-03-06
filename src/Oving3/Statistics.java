package Oving3;
/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;

    //Counters that are needed to answer the assignment, but that are not included in the framework
    /**Number of times the round robin has switched*/
    public long nofProcessChanges = 0;

    public long ioQueueLengthTime = 0;

    public long cpuQueueLengthTime = 0;

    public long largestIOQueue = 0;

    public long largestCPUQueue = 0;

    public long nofCompletedIoOperations = 0;

    public long totalTimeSpentProcessing = 0;

    public long totalTimeInReadyQueue = 0;

    public long totalCpuTime = 0;

    public long totalTimeWaitingForIo = 0;

    public long totalIoTime = 0;

    public long totalNoOfTimesInReadyQueue = 0;

    public long totalNoOfTimesInIoQueue = 0;






	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
		System.out.println();
		System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
        System.out.println("Total time CPU was idle:                                      "+(float)(simulationLength - totalTimeSpentProcessing));
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average time spent waiting for memory per process:            "+
				totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
		}
	}
}
