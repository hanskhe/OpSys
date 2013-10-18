package Oving3;

/**
 * Created with IntelliJ IDEA.
 * User: HK
 * Date: 16.10.13
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class IO {

    private Queue ioQueue;
    private Process activeIOProcess;
    private long avgIoTime;
    private Gui gui;
    private Statistics statistics;

    public IO(Queue ioQueue, long avgIoTime, Gui gui, Statistics statistics){
       this.ioQueue = ioQueue;
       this.avgIoTime = avgIoTime;
       this.gui = gui;
       this.statistics = statistics;
    }

    public void addToIOQueue(Process p){
         ioQueue.insert(p);
         System.out.println("Inserted IO");
         //if (activeIOProcess == null){
             //System.out.println("No Active IO");
           //  startIO();
         //}
    }
    public long getIOTime(){
        //Generating numbers that will average at avgIoTime
        return (long) (Math.random() * (avgIoTime*2));
    }
    public Process startIO(){
        System.out.println("startIO-method called") ;
        if (!ioQueue.isEmpty()){
            System.out.println("IO");
            activeIOProcess = (Process)ioQueue.removeNext();
            gui.setIoActive(activeIOProcess);
            return activeIOProcess;
        }
        else{
            activeIOProcess = null;
            gui.setIoActive(activeIOProcess);
            return activeIOProcess;
        }
    }
    public Process getActiveIOProcess(){
        return activeIOProcess;
    }

    public void removeActiveProcessFromIO(){
        activeIOProcess = null;
        gui.setIoActive(activeIOProcess);
    }

    public void updateTime(long timePassed){
        statistics.ioQueueLengthTime += ioQueue.getQueueLength() * timePassed;
        if (ioQueue.getQueueLength() > statistics.largestIOQueue){
            statistics.largestIOQueue = ioQueue.getQueueLength();
        }
    }
}
