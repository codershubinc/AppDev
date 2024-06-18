import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import coil

class ImageAdapter(private val context: Context, private val imageUrls: Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun getItem(position: Int): Any {
        return imageUrls[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            // If convertView is null, inflate the layout for each item
            imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(350, 350) // Adjust size as per your requirement
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            imageView = convertView as ImageView
        }

        // Load image into ImageView using Coil library
        imageView.load(imageUrls[position])

        return imageView
    }
}
