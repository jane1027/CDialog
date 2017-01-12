package cn.whereyougo.cdialog.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.whereyougo.cdialog.R;


/**
 * function : 自定义对话框.
 * </p>
 * Created by lzj on 2016/1/11.
 */
@SuppressWarnings("unused")
public class CustomDialog extends Dialog {

    public CustomDialog(Activity context) {
        super(context);
    }

    public CustomDialog(Activity context, int theme) {
        super(context, theme);
    }

    /**
     * 信息提示对话框
     * <br/>
     * 默认居于屏幕中间，底部含确认、取消按钮，有标题,各控件可定制
     */
    public static class AlertBuilder {
        private Activity mActivity;
        private LayoutInflater mLayoutInflater;

        private View mView;
        private TextView uiTitleText, uiContentText;
        private ImageView uiTitleIcon;
        private LinearLayout uiLayoutContent;
        private OnClickListener positiveClickListener, negativeClickListener;

        /** 对话框背景资源id */
        private int dialogBgResId = -1;
        /** 对话框背景颜色 */
        private int dialogBgColor = -1;
        /** 标题栏显示状态，默认显示 */
        private int titleLayoutVisibility = View.VISIBLE;
        /** 标题栏背景资源id */
        private int titleBgResId = -1;
        /** 标题icon */
        private int titleIcon = -1;
        /** 标题文本内容 */
        private CharSequence titleText;
        /** 标题文本颜色 */
        private int titleTextColor = -1;
        /** 标题和内容分割线显示状态，默认隐藏 */
        private int titleDividerlineVisibility = View.GONE;
        /** 内容文本 */
        private CharSequence contentText;
        /** 内容文本大小 */
        private float contentTextSize = -1;
        /** 内容文本颜色 */
        private int contentTextColor = -1;
        /** 内容文本对其方式，默认左上角 */
        private int contentTextGravity = Gravity.START | Gravity.TOP;
        /** 自定义对话框内容视图 */
        private View customContentView;
        /** positive按钮文本 */
        private CharSequence positiveBtnText;
        /** positive按钮文本颜色 */
        private int positiveBtnTextColor = -1;
        /** positive按钮背景资源 */
        private int positiveBtnBgResId = -1;
        /** negative按钮文本 */
        private CharSequence negativeBtnText;
        /** negative按钮文本颜色 */
        private int negativeBtnTextColor = -1;
        /** negative按钮背景资源 */
        private int negativeBtnBgResId = -1;
        /** dialog是否可以界外触摸取消 */
        private boolean canceledOnTouchOutside = true;
        /** dialog是否可以取消 */
        private boolean canceled = true;
        /** dialog是否带动画 */
        private boolean isAnim = true;
        /** gif资源内容图片 */
        private int customContentViewGifResId = -1;
        /** 对话框窗体背景灰暗程度 0.0f~1.0f 越大越暗 */
        private float dialogWindowBgDimAcount = 2f;

        public AlertBuilder setDialogBgResId(int dialogBgResId) {
            this.dialogBgResId = dialogBgResId;
            return this;
        }

        public AlertBuilder setDialogBgColor(int dialogBgColor) {
            this.dialogBgColor = dialogBgColor;
            return this;
        }

        public AlertBuilder setTitleLayoutVisibility(int titleLayoutVisibility) {
            this.titleLayoutVisibility = titleLayoutVisibility;
            return this;
        }

        public AlertBuilder setTitleBgResId(int titleBgResId) {
            this.titleBgResId = titleBgResId;
            return this;
        }

        public AlertBuilder setTitleIcon(int titleIcon) {
            this.titleIcon = titleIcon;
            return this;
        }

        public AlertBuilder setTitleText(CharSequence titleText) {
            this.titleText = titleText;
            return this;
        }

        public AlertBuilder setTitleTextColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public AlertBuilder setTitleDividerlineVisibility(int titleDividerlineVisibility) {
            this.titleDividerlineVisibility = titleDividerlineVisibility;
            return this;
        }

        public AlertBuilder setContentText(CharSequence contentText) {
            this.contentText = contentText;
            return this;
        }

        public AlertBuilder setContentTextSize(float contentTextSize) {
            this.contentTextSize = contentTextSize;
            return this;
        }

        public AlertBuilder setContentTextColor(int contentTextColor) {
            this.contentTextColor = contentTextColor;
            return this;
        }

        public AlertBuilder setContentTextGravity(int contentTextGravity) {
            this.contentTextGravity = contentTextGravity;
            return this;
        }

        public AlertBuilder setCustomContentView(View customContentView) {
            this.customContentView = customContentView;
            return this;
        }

        public AlertBuilder setPositiveBtn(CharSequence positiveBtnText, DialogInterface.OnClickListener listener) {
            this.positiveBtnText = positiveBtnText;
            this.positiveClickListener = listener;
            return this;
        }

        public AlertBuilder setPositiveBtnTextColor(int positiveBtnTextColor) {
            this.positiveBtnTextColor = positiveBtnTextColor;
            return this;
        }

        public AlertBuilder setPositiveBtnBgResId(int positiveBtnBgResId) {
            this.positiveBtnBgResId = positiveBtnBgResId;
            return this;
        }


        public AlertBuilder setNegativeBtn(CharSequence negativeBtnText, DialogInterface.OnClickListener listener) {
            this.negativeBtnText = negativeBtnText;
            this.negativeClickListener = listener;
            return this;
        }

        public AlertBuilder setNegativeBtnTextColor(int negativeBtnTextColor) {
            this.negativeBtnTextColor = negativeBtnTextColor;
            return this;
        }

        public AlertBuilder setNegativeBtnBgResId(int negativeBtnBgResId) {
            this.negativeBtnBgResId = negativeBtnBgResId;
            return this;
        }

        public AlertBuilder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public AlertBuilder setCanceled(boolean canceled) {
            this.canceled = canceled;
            return this;
        }

        public AlertBuilder setIsAnim(boolean isAnim) {
            this.isAnim = isAnim;
            return this;
        }

        public AlertBuilder setCustomContentViewGif(int customContentViewGifResId) {
            this.customContentViewGifResId = customContentViewGifResId;
            return this;
        }

        public AlertBuilder setDialogWindowBgDimAcount(float dialogWindowBgDimAcount) {
            this.dialogWindowBgDimAcount = dialogWindowBgDimAcount;
            return this;
        }


        public AlertBuilder(Activity activity) {
            this.mActivity = activity;
            mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @SuppressLint("InflateParams")
        public CustomDialog create() {
            final CustomDialog dialog = new CustomDialog(mActivity, R.style.CD_Dialog_Theme);
            mView = mLayoutInflater.inflate(R.layout.cd_dialog_content, null);

            //对话框背景资源
            LinearLayout uiDialogLayout = (LinearLayout) mView.findViewById(R.id.layout_dialog);
            if (dialogBgResId != -1) {
                uiDialogLayout.setBackgroundResource(dialogBgResId);
            } else if (dialogBgColor != -1) {
                uiDialogLayout.setBackgroundColor(dialogBgColor);
            }

            //标题
            LinearLayout uiLayoutTitle = (LinearLayout) mView.findViewById(R.id.layout_title);
            //标题栏显示状态
            uiLayoutTitle.setVisibility(titleLayoutVisibility);
            //标题栏背景资源
            if (titleBgResId != -1) {
                uiLayoutTitle.setBackgroundResource(titleBgResId);
            }
            //标题icon
            uiTitleIcon = (ImageView) mView.findViewById(R.id.title_icon);
            if (titleIcon != -1) {
                uiTitleIcon.setVisibility(View.VISIBLE);
                uiTitleIcon.setImageResource(titleIcon);
            }
            //标题文本内容
            uiTitleText = (TextView) mView.findViewById(R.id.title_text);
            if (titleText != null && titleText.length() > 0) {
                uiTitleText.setText(titleText);
            }
            //标题文本颜色
            if (titleTextColor != -1) {
                uiTitleText.setTextColor(titleTextColor);
            }
            //标题分割线显示状态
            mView.findViewById(R.id.dividerline_title).setVisibility(titleDividerlineVisibility);

            // 对话框内容
            uiLayoutContent = (LinearLayout) mView.findViewById(R.id.layout_content);
            if (contentText != null) {//默认状态
                uiContentText = ((TextView) mView.findViewById(R.id.content_message));
                uiContentText.setText(contentText);
                if (contentTextSize != -1) {
                    uiContentText.setTextSize(contentTextSize);
                }
                if (contentTextColor != -1) {
                    uiContentText.setTextColor(contentTextColor);
                }
                uiContentText.setGravity(contentTextGravity);
            } else if (customContentView != null) {//自定义内容视图
                uiLayoutContent.removeAllViews();
                uiLayoutContent.addView(customContentView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            } else if (customContentViewGifResId != -1) {//自定义显示gif
                GifView gifView = new GifView(mActivity);
                gifView.setMovieResource(customContentViewGifResId);
                uiLayoutContent.removeAllViews();
                uiLayoutContent.setGravity(Gravity.CENTER);
                uiLayoutContent.addView(gifView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            }

            //底部按钮
            //底部按钮:positive
            TextView uiBtnPositive = (TextView) mView.findViewById(R.id.btn_positive);
            if (positiveBtnText != null && positiveBtnText.length() > 0) {
                uiBtnPositive.setText(positiveBtnText);
                if (positiveBtnTextColor != -1) {
                    uiBtnPositive.setTextColor(positiveBtnTextColor);
                }
                if (positiveBtnBgResId != -1) {
                    uiBtnPositive.setBackgroundResource(positiveBtnBgResId);
                }
                uiBtnPositive.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (positiveClickListener != null) {
                            positiveClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    }
                });
            } else {
                uiBtnPositive.setVisibility(View.GONE);
            }
            //底部按钮:negative
            TextView uiBtnNegative = (TextView) mView.findViewById(R.id.btn_negative);
            if (negativeBtnText != null && negativeBtnText.length() > 0) {
                uiBtnNegative.setText(negativeBtnText);
                if (negativeBtnTextColor != -1) {
                    uiBtnNegative.setTextColor(negativeBtnTextColor);
                }
                if (negativeBtnBgResId != -1) {
                    uiBtnNegative.setBackgroundResource(negativeBtnBgResId);
                }
                uiBtnNegative.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (negativeClickListener != null) {
                            negativeClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                        dialog.cancel();
                    }
                });
            } else {
                uiBtnNegative.setVisibility(View.GONE);
            }

            dialog.setContentView(mView);// 添加视图
            dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
            dialog.setCancelable(canceled);

            // 位置
            Window window = dialog.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
            if (dialogWindowBgDimAcount != 2f && dialogWindowBgDimAcount >= 0f && dialogWindowBgDimAcount <= 1.0f) {
                lp.dimAmount = dialogWindowBgDimAcount;
            }
            window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
            if (isAnim) {
                window.setWindowAnimations(R.style.CD_Dialog_Anim); // 添加动画
            }
            return dialog;
        }
    }

}