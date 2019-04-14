package com.goldminer.model.manager;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import com.goldminer.model.load.ElementLoad;
import com.goldminer.model.vo.Hook;
import com.goldminer.model.vo.SuperElement;

/**
 * 任务：依据参数不同，自动读取 资源，填充 vo对象数据，存储到 元素管理器
 * 	工厂的作用：将比较复杂的 构造方式 进行封装
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
