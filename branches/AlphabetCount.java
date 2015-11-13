// following haoop map reduce programmme count number of words of given length

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;




public class AlphabetCount {
	
	
	public static class Map extends Mapper<LongWritable,Text,IntWritable,Text>{

		public void map(LongWritable key, Text value,
				Context context)
				throws IOException,InterruptedException {
			
			String line = value.toString();
			System.out.println("Mapper Input Value Part VALUE : " + line);
			StringTokenizer tokenizer = new StringTokenizer(line);

			while (tokenizer.hasMoreTokens()) {
				
				
			String word = tokenizer.nextToken();
				
				value.set(word);
				
				context.write(new IntWritable(word.length()),value);
				
			}
	
			
		}
	}
	
	
	public static class Reduce extends Reducer<IntWritable,Text,IntWritable,Text>{

		public void reduce(IntWritable key, Iterable<Text> values,
				Context context)
				throws IOException,InterruptedException {
			int totalNumberOfWordsOfGivenLenth=0;
			String listOfWords = "";
			// TODO Auto-generated method stub
			for(Text x: values)
			{
				totalNumberOfWordsOfGivenLenth=totalNumberOfWordsOfGivenLenth+1;
				listOfWords = listOfWords.concat("    ").concat(x.toString());
			}
			String reducerOp = key +" "+"(As the word of size "+ key+" is:"+ listOfWords +")"; 
			context.write(key, new Text(reducerOp));
			
		}
		
	}
	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration();
		
		Job job = new Job(conf, "alphabetCount");
		job.setJarByClass(AlphabetCount.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		//conf.setMapperClass(Map.class);
		//conf.setReducerClass(Reduce.class);

		job.setOutputKeyClass(IntWritable.class);   //  key outut of the both mapper and reducer
		job.setOutputValueClass(Text.class); // value output of the both mapper and reducer
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);
		

		
		job.setInputFormatClass(TextInputFormat.class); // input format for the input of this application
		job.setOutputFormatClass(TextOutputFormat.class); // output format for the output of this application
		
		

		Path outputPath = new Path(args[1]);
			
	        //Configuring the input/output path from the filesystem into the job
	        
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//deleting the output path automatically from hdfs so that we don't have delete it explicitly
			
		outputPath.getFileSystem(conf).delete(outputPath);
			
			//exiting the job only if the flag value becomes false
			
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		

	}

	
}
