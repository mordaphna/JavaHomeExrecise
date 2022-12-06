package ex2;

public class OS {

    //try and catch in main file? or in Os f

    // a doubly Linked List of nodes representing the nodes that were put to sleep and the time the have
    //to ba awaken after their previews Node
    public static Node headSleepingJobs = null;
    //the tail of the doubly Linked List
    public static Node tailSleepingJobs = null;

    //the jobs Linked list that saves all the jobs needed to be awakened together at a certain time
    public static Job headRunningJobs = null;



    /**
     * Should put the job in the 'sleepingJobs' data structure.
     * @param job - the job to put to sleep
     * @param milliSeconds - the time he needs to sleep
     */
    public static void sleep(Job job, long milliSeconds) {
        try {
            //deleting the job from the running Linked list if she was in it.
            Job current = headRunningJobs;
            if (current != null && current.checkIfJob(current, job)) {
                current.delJob(job);
                job.setPrev(null);
                job.setNext(null);
            }
            // the idea is to save the time deference between the current job with it's prev job.
            //if job1 needs to sleep for 4ms and job2 needs to sleep for 5ms, it means that we need to awake job2
            // 1ms after job1.

            // a Doubly Linked list will save the differences (the Node class). when a new job needs to
            // sleep, we search its place in the linked list. there are 3 possible options:


            if (headSleepingJobs == null) {
                headSleepingJobs = new Node(milliSeconds, job);
                //setting the pointers
                headSleepingJobs.sethHeadOfSleep(job);
                tailSleepingJobs = headSleepingJobs;
            } else {
                long count = 0;
                long timeToWait;

                Node curr = headSleepingJobs;
                while (curr != null) {

                    timeToWait = count + curr.getTimeToEnd();

                    //appending the job to the Node that already exits. the Node saves the time left for the jobs
                    // to wait
                    if (timeToWait == milliSeconds) {
                        //we save all the jobs that needs to wait timeToWait ms in a Job linked List.
                        //so we add the job to end of the Job linkedList.
                        curr.addJob(job);
                        return;

                    }
                    //the node sleeping time is bigger than the current Node timeToWait
                    else if (timeToWait < milliSeconds) {
                        if (curr.getNext() == null) {
                            //if we got to the last Node, and it's bigger from him.
                            //save the difference between him and the prev
                            Node newNode = new Node(milliSeconds - timeToWait, job, curr, null);
                            curr.setNext(newNode);
                            //saving both the head and the tail of the Node Linked List For later
                            tailSleepingJobs = newNode;
                            return;
                        } else {
                            count = timeToWait;
                            curr = curr.getNext();

                        }
                    }

                    //adding a new Node in the middle or in the start . happens if timeToWait > milliSeconds
                    else {
                        Node prev = curr.getPrev();
                        Node newNode = new Node(milliSeconds - count, job, curr.getPrev(), curr);

                        //if putting the node at the start of the LinkedList
                        if (prev == null) {
                            curr.setTimeToEnd(curr.getTimeToEnd() - milliSeconds);
                            headSleepingJobs = newNode;
                            //putting the node in the Middle
                        } else {
                            prev.setNext(newNode);
                            curr.setTimeToEnd(curr.getTimeToEnd() - newNode.getTimeToEnd());

                        }

                        curr.setPrev(newNode);
                        return;
                    }


                }
            }


        } catch (Exception e) {
            System.out.println("error putting to sleep the job " + job.getID());
            //deletes the dataStructure
            headRunningJobs = null;
            headSleepingJobs = null;
            tailSleepingJobs = null;
            //if a job is interrupted, so it might already of connected to the other jobs (in prev or in net
            // pointers), so it is risky to continue, so terminated the program.
            throw e;

        }
    }

    /**
     * Should move the jobs from 'sleepingJobs' to 'runningJobs' when the time to sleep is up.
     */
    public static void awake() {
        try {
            if (headSleepingJobs == null|| tailSleepingJobs == null){
                tailSleepingJobs=null;
                headSleepingJobs=null;
                return;
            }
            //The first node represent the time left until the jobs with this sleeping time needs to be awakened.
            //so describing it every call by 1ms.
            //I only check the head so it O(1) running time.
            headSleepingJobs.decreaseTime();

            //when the time is zero we need to awake them.
            // I will do it by concatenating the tail of the jobLinked List to the head of the runningJobs(O(1))
            if (headSleepingJobs.isTimeEnded()){
                //the tail of the job linked list
                Job jobsToAwake = headSleepingJobs.getTailOfJobList();

                if (headRunningJobs!= null) {
                    headRunningJobs.setPrev(jobsToAwake);
                    jobsToAwake.setNext(headRunningJobs);
                }

                //updating the head to be the head of the jobLinked List I just concatenated
                headRunningJobs = headSleepingJobs.getHeadOfJobList();

                //update his prev to be null
                Node next = headSleepingJobs.getNext();
                if (next!=null){
                    next.setPrev(null);

                }

                //making sure the sleepingLinkedList is deleted
                headSleepingJobs = headSleepingJobs.getNext();
                if (headSleepingJobs == null){
                    tailSleepingJobs = null;
                }
            }

    } catch (Exception e) {
            //error in awake -  deletes the dataStructure and throws e.
            System.out.println("error awaking job/jobs" );
            headRunningJobs = null;
            headSleepingJobs = null;
            tailSleepingJobs = null;
            throw(e);
        }
    }

//    FOR DEBUG

  //  print(headSleepingJobs.getHeadOfJobList()); //TODO: FOR DEBATING

//    public static void print(Job job){
//        while(job!=null){
//            System.out.print(job.getID());
//            System.out.println(" Im a new job going into runningList");
//            job = job.getNext();
//
//        }
//        System.out.println("**********");
//
//    }


}

