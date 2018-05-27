package com.simulator.io;

import java.io.IOException;
import java.util.List;

public interface InstructionParser {
	public List<String> parseFile(String filepath) throws IOException;
}
