package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());

        return new ZipFileManager(zipPath, 0);
    }
    public ZipFileManager getZipFileManagerLevel() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        ConsoleHelper.writeMessage("Введите уровень сжатия:");
        int level = ConsoleHelper.readInt();
        return new ZipFileManager(zipPath, level);
    }
}