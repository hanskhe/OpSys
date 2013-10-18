package Oving3;

/**
 * Created with IntelliJ IDEA.
 * User: HK
 * Date: 16.10.13
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class CPU {

    private Queue cpuQueue;
    private long maxCpuTime;
    private Process activeProcess;
    private Gui gui;
    private Statistics statistics;

    public CPU(Queue cpuQueue, long maxCpuTime, Gui gui, Statistics statistics){
        this.cpuQueue = cpuQueue;
        this.maxCpuTime = maxCpuTime;
        this.gui = gui;
        this.statistics = statistics;
    }

    public void insertProcess(Process p){
        cpuQueue.insert(p);
    }

    public boolean isIdle(){
        return (activeProcess == null);
    }

    public Process startProcess(){
        if (!cpuQueue.isEmpty()){
            activeProcess = (Process)cpuQueue.removeNext();
            gui.setCpuActive(activeProcess);
            return activeProcess;
        }
        else{
            activeProcess = null;
            gui.setCpuActive(activeProcess);
            return activeProcess;
        }
    }

    public Process getActiveProcess(){
        return activeProcess;
    }

    public void removeActiveProcessFromCPU(){
          activeProcess = null;
           gui.setCpuActive(activeProcess);
    }

    public long getMaxCpuTime(){
        return maxCpuTime;
    }

    public void updateTime(long timePassed){
        statistics.cpuQueueLengthTime += this.cpuQueue.getQueueLength() * timePassed;
        if (this.cpuQueue.getQueueLength() > statistics.largestCPUQueue){
            this.statistics.largestCPUQueue = this.cpuQueue.getQueueLength();
        }
    }


}
