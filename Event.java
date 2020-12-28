
/**
 * Event Class to keep track of the Events
 * i.e Customers either arriving or departing
 */

public  class Event implements Comparable<Event>{
        static final int ARRIVE = 1; //identify an event as arrival
        static final int DEPART = 2;  //identify an event as departure after service
        int time; //time at which the even happens
        int type; // used to initially set the event as either arrival or departure
        Customer Cstmr; //Customer to which the event relates

        
        /**
         * Custructor for the Event
         * @param int time, int type, Customer Cstmr 
         */
        public Event (int time, int type, Customer Cstmr ){
            this.time = time;
            this.type = type;
            this.Cstmr = Cstmr;
        }
        
        /**
         * Used to compare one event to another based on what time they occur
         * @param Event rhs
         * @return int either 1, 0 or -1 following the normal convention of comparing
         */
        public int compareTo(Event rhs){
            return this.time - rhs.time;
        }

    }
