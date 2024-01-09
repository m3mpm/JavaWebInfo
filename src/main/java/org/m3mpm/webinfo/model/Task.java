package org.m3mpm.webinfo.model;

import java.util.Objects;

public class Task {
    private String title;
    private String parentTask;
    private Integer maxXp;

    public Task() {
    }

    public Task(String title, String parentTask, Integer maxXp) {
        this.title = title;
        this.parentTask = parentTask;
        this.maxXp = maxXp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public Integer getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(Integer maxXp) {
        this.maxXp = maxXp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(parentTask, task.parentTask) && Objects.equals(maxXp, task.maxXp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, parentTask, maxXp);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXp=" + maxXp +
                '}';
    }
}
