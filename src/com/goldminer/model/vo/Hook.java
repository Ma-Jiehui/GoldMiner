package com.goldminer.model.vo;
/**
 *������,�����ӵ�������Ϊ,
 *�����ڶ�,����,��������,����ը�� 
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;

import com.goldminer.model.manager.ElementManager;
import com.goldminer.model.manager.HookState;

public class Hook extends SuperElement {
	public static Hook hook;
	private int point;
    private double sourceX; //���ҵ�
    private double sourceY; //���ҵ�
    private static double theta; //�Ƕ�
    private double d; //����
    final double r; //���Ӵ�С
    private double weight; //���ӵ�ǰ������(��������800)
    private int power;//���ӵ�����
    private Mineral mineral;//����������
    HookState state; //���ӵ��н�״̬
    
    
    int hookWaitDirection = 1; //���ƹ��ӻζ��ķ���
    public Hook(double panelWidth,double panelHeight) {
    	sourceX = panelWidth/2;
        sourceY = panelHeight; //��Ҫ���ݱ������ڵ����ʵ���ʼ�߶�
        point=0;
        theta=0.0;
        d=0.0;
        r=30;
        weight=800.0;
        power=3000;
        state = HookState.WAIT;
	}
    public static Hook createHook() {
		if(hook==null) {
			return new Hook(820,620); 
		}else {
			return hook;
		}
	}
    
    public void update(){
		move();
		hookMineral();
		hookBomb();
		destroy();
	}
    
    @Override
	public void showElement(Graphics g) {
		// TODO Auto-generated method stub
    	g.drawImage(getImg().getImage(), 
    			getX()-getR(), getY()-getR(), getX()+getR(), getY()+getR(),
    			0, 0, getImg().getImage().getWidth(null), getImg().getImage().getHeight(null), null);
	}
    @Override
	public void move() {
		// TODO Auto-generated method stub
    	switch (state) {
		case WAIT:
			theta += hookWaitDirection * Math.PI/(2*24);// TODO ��һ�˵���һ����������*ÿ��֡�� ֮��֡�����Կ������óɲ���
			if (theta >= Math.PI * 47/48) {
        		hookWaitDirection = -1;
        	}
        	else if (theta <= Math.PI / 48) {
        		hookWaitDirection = 1;
        	}
            break;
		case FORWARD:
			d += getPushVelocity();
        	
        	/*�ж��Ƿ񳬳��߽�*/
        	if (getX() < 0 || getX() > 620 || getY() > 820) {
        		state = HookState.BACKWARD_WITHOUT_MINERAL;
        		break;
        	}
		case BACKWARD_WITH_MINERAL:
			d-=getPullVelocity();
			if(d-getPullVelocity()<=0) {
				state=HookState.WAIT;
				
			}
			break;
		case BACKWARD_WITHOUT_MINERAL:
			d-=getPullVelocity();
			if(d-getPullVelocity()<=0) {
				state=HookState.WAIT;
			}
			break;
		default:
			break;
		}
	}
    public void addPoint() {
    	this.point+=this.mineral.value;
    	this.mineral.setVisible(false);
    	this.mineral=null;
	}
    public int getX(){
    	return getX();
    }
    public int getY(){
    	return getY();
    }
    public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getWeight(){
    	return mineral == null ? weight : weight 
        		+ mineral.density * mineral.getR() * mineral.getR();
    }
    public double getPullVelocity(){
    	return power/getWeight();
    }
    public double getPushVelocity(){
    	return 20;//�����ͷ��ٶ�
    }
    public boolean hasMineral(){
    	return mineral!=null;
    }
    public void pushHook() {
		this.state=HookState.FORWARD;
	}
    public boolean hookMineral(){
    	List<SuperElement> mineralList=ElementManager.getManager().getElementList("mineralList");
    	for(int i=0,len = mineralList.size();
    			i<len; ++i) {
            	Mineral m=(Mineral)mineralList.get(i);
            	if(distance(getX(), getY(), m.getX(), m.getY())<m.getR()) {
            		state = HookState.BACKWARD_WITH_MINERAL;
            		m.setHooked(true);
            		this.mineral=m;
            		this.weight+=m.density*m.getR()*m.getR();
            		return true;
            	}
        }
    	return false;
    }
    public boolean hookBomb(){
    	List<SuperElement> bombList=ElementManager.getManager().getElementList("bombList");
    	for(int i=0,len = bombList.size();
    			i<len; ++i) {
            	Bomb b = (Bomb)bombList.get(i);
            	if (distance(getX(), getY(), b.getX(), b.getY()) < (getR() + b.getR())) {
            		state = HookState.BACKWARD_WITHOUT_MINERAL;
            		bombList.remove(i);
            		b.explode();
            		len = bombList.size();
            		--i;
            		return true;
            	}
        }
    	return false;
    }
    private static double distance(double x1,double y1,double x2,double y2){
    	return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
        final double theta){
    	int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(theta, w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }

	@Override
	public void destroy() {
		
	}
	public double getSourceX() {
		return sourceX;
	}
	public void setSourceX(double sourceX) {
		this.sourceX = sourceX;
	}
	public double getSourceY() {
		return sourceY;
	}
	public void setSourceY(double sourceY) {
		this.sourceY = sourceY;
	}
	public static double getTheta() {
		return theta;
	}
	public void setTheta(double theta) {
		this.theta = theta;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public HookState getState() {
		return state;
	}
	public void setState(HookState state) {
		this.state = state;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	

}
