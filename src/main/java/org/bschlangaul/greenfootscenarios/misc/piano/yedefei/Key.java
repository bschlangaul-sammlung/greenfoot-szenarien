package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*;


/**
 * Write a description of class Key2 here.
 *
 */
public class Key extends Actor
{
    /**
     * Act - do whatever the Key2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    private boolean isDown; // ��¼�ټ������Ƿ��ڼ��̰���״̬
    private boolean isPressed; // ��¼�ټ������Ƿ��ڱ���갴ס״̬
    private boolean isHover; // ��¼�ټ������Ƿ��������ͣ״̬
    private boolean isDragged; // ��¼�ټ������Ƿ�������϶�״̬
    private boolean isNoteRain; // ��¼�������Ƿ�������״̬���Ӱ��°�����̧�𰴼���Ϊ�����괦������״̬��
    private NoteRain noterain;

    private String keyType; // ��¼�ټ���Ϊ�ڼ����ǰ׼�
    private int scale; // �ټ���Ӧ�����ף��涨�������ף���2��7��2��6�����߸�����ȫ����������ֻ��do��
    private String keyboardName; // �����Ա����key��ʾ���԰����ļ���(ֻ�а׼��ж�Ӧ��λ)
    private String soundName; // �ټ���Ӧ��������

    private GreenfootImage Image; // �ټ������Ч��ͼƬ
    private GreenfootImage hoverImage; // �ټ��������������Ч��ͼƬ
    private GreenfootImage mouseDownImage; // �ټ�����갴�µ�Ч��ͼƬ
    private GreenfootImage keyboardDownImage; // �ټ�����갴�µ�Ч��ͼƬ

    public Key(String keyType, int scale, String keyboardName, String soundName)
    {
        this.keyType = keyType;
        this.scale = scale;
        this.keyboardName = keyboardName;
        this.soundName = soundName;

        Image = new GreenfootImage(keyType + "Key.png");
        hoverImage = new GreenfootImage(keyType + "KeyHover.png");
        mouseDownImage = new GreenfootImage(keyType + "MouseDown.png");


        if (keyType == "white")
        {
            keyboardDownImage = new GreenfootImage(keyType + "KeyboardDown.png");
            drawImage(Image, false);
            drawImage(hoverImage, false);
            drawImage(mouseDownImage, false);
            drawImage(keyboardDownImage, true);
        }
        setImage(Image);
    }

    public void drawImage(GreenfootImage image, boolean isOffset)
    {
        // �����̶�Ӧ�ַ�
        int offset = 0;
        if (isOffset)
            offset = 2;
        image.setFont(new Font("΢���ź�", true, false, 20));
        image.setColor(new Color(55, 55, 55));
        image.drawString(keyboardName, 12, 215 + offset);
        // ���ټ�ǰ��С����
        image.setColor(KeysScaleColor.getScaleColor(scale));
        image.fillRect(8, 238 - offset, 22, 22);
        // ���ټ�ǰ��С�����������
        image.setFont(new Font("΢���ź�", true, false, 14));
        image.setColor(new Color(55, 55, 55));
        image.drawString(soundName, 10, 256 - offset);
    }

    public void act()
    {
        if (keyType == "white")
        {
            keyDownEvent();
        }
        if (!isDown)
        {
            mouseClickedEvent();
            mouseDraggedEvent();
            mouseHoverEvent();
        }
    }

    public void keyDownEvent()
    {
        if (!isDown && Greenfoot.isKeyDown(keyboardName))
        {
            Greenfoot.playSound(scale + "/" + soundName + ".mp3");
            setImage(keyboardDownImage);
            isDown = true;
            NoteRainGenerate("start");
        }
        if (isDown && !Greenfoot.isKeyDown(keyboardName))
        {
            setImage(Image);
            isDown = false;
            NoteRainGenerate("stop");
        }
    }

    public void mouseClickedEvent()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null)
        {
            if (!isPressed && Greenfoot.mousePressed(this) && getX() + 19 > mouseInfo.getX()
                            && getX() - 19 < mouseInfo.getX() && getY() + 138 > mouseInfo.getY()
                            && getY() + 26 < mouseInfo.getY() && keyType == "white"
                            && mouseInfo.getButton() == 1)
            {
                Greenfoot.playSound(scale + "/" + soundName + ".mp3");
                setImage(mouseDownImage);
                isPressed = true;
                NoteRainGenerate("start");
            }
            else if (!isPressed && Greenfoot.mousePressed(this) && getX() + 13 > mouseInfo.getX()
                            && getX() - 13 < mouseInfo.getX() && getY() + 82 > mouseInfo.getY()
                            && getY() - 82 < mouseInfo.getY() && keyType == "black"
                            && mouseInfo.getButton() == 1)
            {
                Greenfoot.playSound(scale + "/" + soundName + ".mp3");
                setImage(mouseDownImage);
                isPressed = true;
                NoteRainGenerate("start");
            }
            if (isPressed && Greenfoot.mouseClicked(this))
            {
                setImage(Image);
                isPressed = false;
                NoteRainGenerate("stop");
            }
        }
    }

    public void mouseHoverEvent()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null && !isPressed && !isDown && !isDragged)
        {
            if (getX() + 19 > mouseInfo.getX() && getX() - 19 < mouseInfo.getX()
                            && getY() + 138 > mouseInfo.getY() && getY() + 26 < mouseInfo.getY()
                            && keyType == "white")
            {
                setImage(hoverImage);
                isHover = true;
            }
            else if (getX() + 13 > mouseInfo.getX() && getX() - 13 < mouseInfo.getX()
                            && getY() + 82 > mouseInfo.getY() && getY() - 82 < mouseInfo.getY()
                            && keyType == "black")
            {
                setImage(hoverImage);
                isHover = true;
            }
            else
            {
                if (isHover)
                {
                    setImage(Image);
                    isHover = false;
                }
            }
        }
    }

    public void mouseDraggedEvent()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null)
        {
            if (getX() + 19 > mouseInfo.getX() && getX() - 19 < mouseInfo.getX()
                            && getY() + 138 > mouseInfo.getY() && getY() + 26 < mouseInfo.getY()
                            && keyType == "white" && mouseInfo.getButton() == 1
                            && !Greenfoot.mouseClicked(this))
            {
                Greenfoot.playSound(scale + "/" + soundName + ".mp3");
                setImage(mouseDownImage);
                isDragged = true;
                NoteRainGenerate("start");
            }
            if (getX() + 13 > mouseInfo.getX() && getX() - 13 < mouseInfo.getX()
                            && getY() + 82 > mouseInfo.getY() && getY() - 82 < mouseInfo.getY()
                            && keyType == "black" && mouseInfo.getButton() == 1
                            && !Greenfoot.mouseClicked(this))
            {
                Greenfoot.playSound(scale + "/" + soundName + ".mp3");
                setImage(mouseDownImage);
                isDragged = true;
                NoteRainGenerate("start");
            }
            if (isDragged && (getX() + 19 < mouseInfo.getX() || getX() - 19 > mouseInfo.getX()
                            || getY() + 138 < mouseInfo.getY() || getY() + 26 > mouseInfo.getY()))
            {
                setImage(Image);
                isDragged = false;
                NoteRainGenerate("stop");
            }
        }
    }

    public void autoPlay(String type)
    {
        if (type == "press")
        {
            Greenfoot.playSound(scale + "/" + soundName + ".mp3");
            setImage(mouseDownImage);
            NoteRainGenerate("start");
        }
        if (type == "uplift")
        {
            setImage(Image);
            NoteRainGenerate("stop");
        }
    }

    public void NoteRainGenerate(String state)
    {
        if (keyType == "white")
        {
            if (state == "start" && isNoteRain == false)
            {
                noterain = new NoteRain(30);
                getWorld().addObject(noterain, getX(), getY() - 138);
                isNoteRain = true;
            }
            if (state == "stop" && isNoteRain == true)
            {
                isNoteRain = false;
                noterain.setIsGrow(false);
            }
        }
        if (keyType == "black")
        {
            if (state == "start" && isNoteRain == false)
            {
                noterain = new NoteRain(20);
                getWorld().addObject(noterain, getX(), getY() - 82);
                isNoteRain = true;
            }
            if (state == "stop" && isNoteRain == true)
            {
                isNoteRain = false;
                noterain.setIsGrow(false);
            }
        }
    }
}
