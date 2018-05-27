package com.simulator.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InstructionParserImpl implements InstructionParser {

	@Override
	public List<String> parseFile(String filepath) throws IOException {
		List<String> instructions = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
		for(String line = br.readLine(); line != null; line = br.readLine()) {
			instructions.add(line);
		}
		br.close();
		return instructions;
	}

}
