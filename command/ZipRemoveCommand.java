package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.AbsolutePathRemoveException;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {

            ConsoleHelper.writeMessage("Удаление файла из архива.");

            ZipFileManager zipFileManager = getZipFileManagerLevel();

            ConsoleHelper.writeMessage("Введите относительный путь файла к архиву:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            if (sourcePath.isAbsolute()){
                throw new AbsolutePathRemoveException();
            }
            zipFileManager.removeFile(sourcePath);

            ConsoleHelper.writeMessage("Удаление из архива завершено.");
        }catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Файл не найден");
        }
    }
}