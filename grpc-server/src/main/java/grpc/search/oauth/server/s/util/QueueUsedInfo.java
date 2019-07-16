package grpc.search.oauth.server.s.util;

public class QueueUsedInfo implements Comparable {


    @Override
    public int compareTo(Object o) {

        QueueUsedInfo queueUsedInfo = (QueueUsedInfo) o;

        if (this.absoluteUnUsedCapacity.compareTo(queueUsedInfo.absoluteUnUsedCapacity) > 0)
            return -1;
        else if (this.absoluteUnUsedCapacity.compareTo(queueUsedInfo.absoluteUnUsedCapacity) < 0)
            return 1;

        return 0;
    }

    String parentQueueName;
    String queueName;
    String absoluteUsedCapacity;
    String absoluteMaxCapacity;
    String absoluteUnUsedCapacity;

    public QueueUsedInfo() {
    }

    public String getAbsoluteUnUsedCapacity() {
        return absoluteUnUsedCapacity;
    }

    public void setAbsoluteUnUsedCapacity(String absoluteUnUsedCapacity) {
        this.absoluteUnUsedCapacity = absoluteUnUsedCapacity;
    }

    public QueueUsedInfo(String parentQueueName, String queueName, String absoluteUsedCapacity,
                         String absoluteMaxCapacity) {
        this.parentQueueName = parentQueueName;
        this.queueName = queueName;
        this.absoluteUsedCapacity = absoluteUsedCapacity;
        this.absoluteMaxCapacity = absoluteMaxCapacity;
        this.absoluteUnUsedCapacity = Float.parseFloat(absoluteMaxCapacity) - Float.parseFloat(absoluteUsedCapacity) + "";
    }

    @Override
    public String toString() {
        return "QueueUsedInfo{" +
                "parentQueueName='" + parentQueueName + '\'' +
                ", queueName='" + queueName + '\'' +
                ", absoluteUsedCapacity='" + absoluteUsedCapacity + '\'' +
                ", absoluteMaxCapacity='" + absoluteMaxCapacity + '\'' +
                ", absoluteUnUsedCapacity='" + absoluteUnUsedCapacity + '\'' +
                '}';
    }

    public String getParentQueueName() {
        return parentQueueName;
    }

    public void setParentQueueName(String parentQueueName) {
        this.parentQueueName = parentQueueName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getAbsoluteUsedCapacity() {
        return absoluteUsedCapacity;
    }

    public void setAbsoluteUsedCapacity(String absoluteUsedCapacity) {
        this.absoluteUsedCapacity = absoluteUsedCapacity;
    }

    public String getAbsoluteMaxCapacity() {
        return absoluteMaxCapacity;
    }

    public void setAbsoluteMaxCapacity(String absoluteMaxCapacity) {
        this.absoluteMaxCapacity = absoluteMaxCapacity;
    }
}
