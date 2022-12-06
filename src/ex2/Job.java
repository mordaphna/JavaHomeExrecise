package ex2;

/**
 * this class represents a job class
 * every job has a prev and a next --> so it's representing a Doubly linkedList as well
 * the job LinkedList will represent the jobs that needed to be awakened in a certain time.
 */
public class Job {
    private final int id;
    private Job prev = null;
    private Job next = null;

    /**
     * create a job with a unique id
     * @param id - unique integer;
     */
    public Job(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public Job getNext() {
        return next;
    }

    public void setNext(Job next) {
        this.next = next;
    }

    public void setPrev(Job prev) {
        this.prev = prev;
    }

    /**
     * check if a job exits in the jobLinkedList
     * @param head - the head of the List search in
     * @param job - the job to look for
     * @return  - true if found else false
     */
    public boolean checkIfJob(Job head, Job job){
        while( head!=null){
            if(head.id == job.id){
                return true;
            }
             head = head.getNext();
        }
        return false;
    }

    /**
     * deletes job from the jobLinkedList. update pointers accordingly
     * @param job - the job to delete
     */
    public void delJob(Job job){

        Job prev = job.prev;
        Job next = job.next;
        if(prev!=null) {
            prev.setNext(next);
        }
        if(next!=null) {
            next.setPrev(prev);
        }
    }


    // A function for sleep which called by a job
    public void sleep(long ms)  {
        OS.sleep(this, ms);
    }

}