package org.example.volatileBlock.volatileex;

public class Exchanger {
    private Object object = null;
    private volatile boolean hasNewObject;

    public void setObject(Object object) {
        this.object = object;
        hasNewObject = true;
    }

    public Object getObject() {
        while (!hasNewObject) {
            //busy waiting
        }

        var returnValue = this.object;
        this.hasNewObject = false;
        return returnValue;
    }
}
