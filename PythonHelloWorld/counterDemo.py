import tkinter as tk

# Function to update the counter
def update_counter():
    global counter
    counter += 1
    counter_label.config(text=f"Counter: {counter}")

# Initialize the counter
counter = 0

# Create a main window
root = tk.Tk()

# Frame 1 with a button and a counter label
frame1 = tk.Frame(root)
frame1.pack()

counter_label = tk.Label(frame1, text=f"Counter: {counter}")
counter_label.pack()

update_button = tk.Button(frame1, text="Increment", command=update_counter)
update_button.pack()

# Frame 2 with a label, a button, and checkboxes
frame2 = tk.Frame(root)
frame2.pack()

label2 = tk.Label(frame2, text="Frame 2")
label2.pack()

button2 = tk.Button(frame2, text="Button 2")
button2.pack()

checkbox1 = tk.Checkbutton(frame2, text="Checkbox 1")
checkbox1.pack()

checkbox2 = tk.Checkbutton(frame2, text="Checkbox 2")
checkbox2.pack()

checkbox3 = tk.Checkbutton(frame2, text="Checkbox 3")
checkbox3.pack()

# Start the Tkinter main loop
root.mainloop()

