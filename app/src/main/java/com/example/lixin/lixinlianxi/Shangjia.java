package com.example.lixin.lixinlianxi;

import java.util.List;

/**
 * Created by hua on 2017/9/22.
 */

public class Shangjia {
    boolean isChcked;
    List<ShangPin> shangPinList;

    public boolean isChcked() {
        return isChcked;
    }

    public void setChcked(boolean chcked) {
        isChcked = chcked;
    }

    public List<ShangPin> getShangPinList() {
        return shangPinList;
    }

    public void setShangPinList(List<ShangPin> shangPinList) {
        this.shangPinList = shangPinList;
    }
}
