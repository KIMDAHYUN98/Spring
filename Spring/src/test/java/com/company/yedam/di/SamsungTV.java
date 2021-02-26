package com.company.yedam.di;

public class SamsungTV implements TV {

	Speaker speaker;
	public SamsungTV() {} // 기본 생성자
	public SamsungTV(Speaker speaker) { // 초기화 작업
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
