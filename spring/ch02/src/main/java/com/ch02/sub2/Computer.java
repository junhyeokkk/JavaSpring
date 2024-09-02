package com.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {

    // 필드 주입
    @Autowired
    private CPU cpu;

    // 생성자 주입 (권장)
    private RAM ram;

    @Autowired
    public Computer(RAM ram){
        this.ram = ram;
    }


    // SETTER 주입
    private SSD ssd;

    @Autowired
    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public void show(){
        cpu.show();
        ram.show();
        ssd.show();
    }

}
