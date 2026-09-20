package com.nhlstenden.appstoresystem;

public class DownloadNotAllowedException extends RuntimeException
{
    public DownloadNotAllowedException(String message)
    {
        super(message);
    }
}
