package ex2;

/**
 * this class representing a Node in a doubly linked List.
 * Iam saving the head of the list and the tail of the list in every Node
 * every Node will represent the time left for him to wait, after his prev node will be awake.
 * in every node i will save a Job doubly linked List, representing the  jobs needed to be awake in timeToEnd.
 */


public class Node{
    private long timeToEnd;
    private Job tailSleepingJobList;
    private Node prev = null;
    private Node next = null;
    private Job headOfSleep = null;

    /**
     *
     * @param time - the time to wait from when my prev node has been awakened.
     *             if no prev, time equals the ms sleep parameter.
     * @param curr - the first job that needs to be awakened in timeToEnd ms
     * @param prev - the prev Node
     * @param next - the next Node
     */
    public Node(long time, Job curr, Node prev, Node next){
        this.timeToEnd = time;
        tailSleepingJobList  = curr;
        headOfSleep = curr;
        this.prev = prev;
        this.next = next;

    }

    /**
     * another constructor
     */
    public Node(long time, Job curr){
        this.timeToEnd = time;
        tailSleepingJobList = curr;

    }

    /**
     * setting and returning the timeToEnd
     */

    public void setTimeToEnd(long timeToEnd){
        this.timeToEnd = timeToEnd;
    }
    public long getTimeToEnd(){
        return timeToEnd;
    }

    /**
     * increasing time by 1 every call
     */

    public void decreaseTime(){
        this.timeToEnd-=1;
    }

    /**
     * getting and setting prev and next
     */
    public void setPrev(Node prev){
        this.prev = prev;
    }

    public Node getPrev(){
        return prev;
    }


    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    /**
     *
     * @return  return the tail of the job list in current Node
     */
    public Job getTailOfJobList(){
        return tailSleepingJobList;
    }

    /**
     * adding job to the jobLinkedList, update pointers
     * @param job - the job to add
     */

    public void addJob(Job job){
        tailSleepingJobList.setNext(job);
        job.setPrev(tailSleepingJobList);

        //the tail of the list
        tailSleepingJobList = job;

    }

    /**
     *
     * setting and returning the head og the jobLinkedList
     */

    public Job getHeadOfJobList() {
        return headOfSleep;
    }

    public void sethHeadOfSleep(Job job){
        this.headOfSleep = job;
    }


    /**
     * check if time ended
     * @return true if ended, else false
     */
    public boolean isTimeEnded(){
        return this.timeToEnd == 0;
    }


}


