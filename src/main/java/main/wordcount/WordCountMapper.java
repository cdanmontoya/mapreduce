package main.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

  private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
  private final static IntWritable ONE = new IntWritable(1);
  private Text word = new Text();

  @Override
  protected void map(Object key, Text value,
      Mapper<Object, Text, Text, IntWritable>.Context context)
      throws IOException, InterruptedException {
    logger.info("Executing map function");
    logger.info("Mapper input: " + value);

    StringTokenizer itr = new StringTokenizer(value.toString());

    while (itr.hasMoreTokens()) {
      word.set(itr.nextToken());
      context.write(word, ONE);
      logger.info("Mapper emitted (" + word + ":" + ONE + ")");
    }
  }
}
