package design; /**
 * Created by zhaocl on 2022/1/23 17:48.
 * desc：
 */


import javax.jws.HandlerChain;

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2022-01-23 17:48
 **/

 public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }

    static class HandlerChain {
        private Handler head = null;
        private Handler tail = null;

        public void addHandler(Handler handler) {
            handler.setSuccessor(null);
            if (head == null) {
                head = handler;
                tail = handler;
                return;
            }
            tail.setSuccessor(handler);
            tail = handler;
        }

        public void handle() {
            if (head != null) {
                head.handle();
            }
        }
    }
}

class HandlerA extends Handler {
   @Override
   protected boolean doHandle() {
       boolean handled = false;
       //...
       return handled;
   }
}

class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        //...
        return handled;
    }


}



// HandlerChain和Application代码不变
