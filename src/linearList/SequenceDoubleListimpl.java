package linearList;


public class SequenceDoubleListimpl implements ISequence {

    private class Node  {
        Object data;
        Node next;
        Node prev;

        //构造
        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public void add(Object data) {

        }

        //虚拟头节点
        private Node dummyHead;
        //私有头节点
        private Node head;
        //私有长度
        private int size;

        @Override
        public boolean remove(int index) {
            rangCheck(index);
            return false;
        }

        @Override
        public Object get(int index) {
            rangCheck(index);
            return null;
        }

        @Override
        public Object contains(Object data) {
            return null;
        }

        @Override
        public Object set(int index, Object newData) {
            rangCheck(index);
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void clear() {

        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        private void rangCheck(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("index error");
            }
        }

}
