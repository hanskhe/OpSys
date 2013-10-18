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

    public IO(Queue ioQueue, long avgIoTime, Gui gui){
       this.ioQueue = ioQueue;
       this.avgIoTime = avgIoTime;
       this.gui = gui;
    }

    public void addToIOQueue(Process p){
         ioQueue.insert(p);
    }

    public Process getFromIOQueue(){
        return (Process)ioQueue.getNext();
    }
    public void removeFromIOQueue(){
        ioQueue.removeNext();
    }
    public long getIOTime(){
        //Generating numbers that will average at avgIoTime
        return (long) Math.random() * (avgIoTime*2);
    }
    public Process startIO(){
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
}
