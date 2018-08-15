package huahong.kotlindemo.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by admin on 2017/9/20.
 */
abstract class BaseObjectAdapter<T>(var mTs : List<T>) : BaseAdapter() {


    override fun getItem(position: Int): T {
        return mTs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mTs.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val baseViewHolder : BaseViewHolder<T>?

        val bean : T = getItem(position)

        if (convertView == null) {

            baseViewHolder = creatViewHolder(parent)

            baseViewHolder?.init()

        }else {

            baseViewHolder = convertView.tag as BaseViewHolder<T>
        }

        baseViewHolder?.refresh(bean,position)


        return baseViewHolder?.getRootView()


    }

    abstract fun creatViewHolder(parent: ViewGroup?): BaseViewHolder<T>?


}