package main.wordcount;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

  private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
  private IntWritable result = new IntWritable();

  @Override
  protected void reduce(Text key, Iterable<IntWritable> values,
      Reducer<Text, IntWritable, Text, IntWritable>.Context context)
      throws IOException, InterruptedException {

    logger.info("Executing reducer function on key" + key);

    int sum = 0;

    for (IntWritable val : values) {
      sum += val.get();
    }

    result.set(sum);
    context.write(key, result);

    logger.info("Reducer emited (" + key + ":" + result + ")");
  }
}
