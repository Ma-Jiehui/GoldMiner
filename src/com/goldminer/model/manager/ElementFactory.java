package com.goldminer.model.manager;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import com.goldminer.model.load.ElementLoad;
import com.goldminer.model.vo.Hook;
import com.goldminer.model.vo.SuperElement;

/**
 * �������ݲ�����ͬ���Զ���ȡ ��Դ����� vo�������ݣ��洢�� Ԫ�ع�����
 * 	���������ã����Ƚϸ��ӵ� ���췽ʽ ���з�װ
 */
public class ElementFactory {
	
	public static SuperElement elementFactory(String name){
		Map<String, ImageIcon> imgMap=
			ElementLoad.getElementLoad().getImgMap();
		Map<String, String> proMap=ElementLoad.getElementLoad().getProMap();
		Map<String, List<String>> levelMap=ElementLoad.getElementLoad().getSounMap();
		Map<String,Object> map=ElementLoad.getElementLoad().getLevelList();
		switch(name){
		case "hook":
				return Hook.createHook();
		case "gold":
			break;
		}
		
		return null;
	}
	
	
}
