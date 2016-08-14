package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {
	// ������ʾ�Ŀؼ�
	private Button leftButton, rightButton;
	private TextView tvTittle;

	// ���Button������
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	// �ұ�Button������
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	// �м�Title������
	private String tittle;
	private float tittleTextSize;
	private int tittleTextColor;
	// ���������ؼ��ĸ�ʽ ����˵�ǲ���
	private LayoutParams leftParams, rightParams, tittleParams;

	//����ӿ�
	private TopBarListener topBarListener;
	//���巽��ʹ�ýӿڻ���   �÷�������ҪĿ���Ǳ�¶��ʹ����   ʹ����ͨ����дtopBarListener�ķ���   ʵ��onClick�Ĺ���
	public void setOnLeftButtonClickListener(TopBarListener topBarListener){
		this.topBarListener = topBarListener;
	}
	/**
	 * �ڹ��캯������ɿؼ��ĳ�ʼ�� ʹ�ýӿڵĻص�����ʵ�ֵ���¼� ��ȡxml�е�����
	 * 
	 * @param context
	 * @param attrs
	 */
	@SuppressLint("NewApi")
	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.TopBar);
		leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
		leftText = ta.getString(R.styleable.TopBar_leftText);

		rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
		rightText = ta.getString(R.styleable.TopBar_rightText);

		tittle = ta.getString(R.styleable.TopBar_tittle);
		tittleTextColor = ta.getColor(R.styleable.TopBar_tittleTextColor, 0);
		tittleTextSize = ta.getDimension(R.styleable.TopBar_tittleTextSize, 0);

		ta.recycle();

		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTittle = new TextView(context);

		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);

		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);

		tvTittle.setText(tittle);
		tvTittle.setTextColor(tittleTextColor);
		tvTittle.setTextSize(tittleTextSize);
		tvTittle.setGravity(Gravity.CENTER);

		setBackgroundColor(0xFFF59563);

		// �������Button�Ĳ���
		// ��WRAP_CONTENT �ߣ�WRAP_CONTENT ���֣��������
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		addView(leftButton, leftParams);

		// �ұ߰�ť������
		// ��WRAP_CONTENT �ߣ�WRAP_CONTENT ���֣����Ҷ���
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);

		// �м�Tittle������
		tittleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		tittleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTittle, tittleParams);

		// ʹ�ýӿڻص����� ʵ�ְ�ť�ĵ���¼�
		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				topBarListener.leftButtonClick();
			}
		});

	}

}
