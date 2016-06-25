import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class UniqueStoreMap extends Mapper<LongWritable,Text,IntWritable,NullWritable> {
	
	public void map(LongWritable key,Text value,Context context){
		if (Long.parseLong(key.toString()) == 0)
			return;
		else{
		String[] val = value.toString().split(",");
		String store = (val[2]);
		String in_stock = (val[4]);
		if(in_stock.equals("false")){
		try {
			context.write(new IntWritable(Integer.parseInt(store)),NullWritable.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	}
}
