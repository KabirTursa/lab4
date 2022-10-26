class DebuggingExercise4
{
    public static void main(String[] args)
    {
        Account a = new Account("Bob");
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
        a.withdraw(42);
        System.out.println("After trying to withdraw $42, " + a.getOwner() + " has $" + a.getBalance());
    }
}

/* ANSWERS TO QUESTIONS:
2.
    a. The variable watch window is at the bottom of my screen
    b. The method call stack is to the left of the variable watch window
3.
    a. Step over lets you execute the next command. If that's a loop or a method call, it will do that entire
        process and not take you inside of it.
    b. Step into also lets you execute the next statement. If that's a loop, method call, etc. It takes you inside
        that process. This is different from step over since it goes inside methods and loops instead of past them.
    c. Step out takes you out of a call, loop, etc. This is basically the opposite of step into, and if you didn't
        want to step into something, you can step out as an undo.
    d. Continue just runs the rest of the code like normal. This basically takes you out of debug mode, meaning you
        can't go 1 step at a time. It just executes the code like it would if you weren't in debug mode.

 */